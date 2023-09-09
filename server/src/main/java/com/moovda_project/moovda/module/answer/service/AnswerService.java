package com.moovda_project.moovda.module.answer.service;

import com.moovda_project.moovda.global.utils.MemberIdExtractor;
import com.moovda_project.moovda.module.answer.entity.Answer;
import com.moovda_project.moovda.module.answer.repository.AnswerRepository;
import com.moovda_project.moovda.global.exception.BusinessLogicException;
import com.moovda_project.moovda.global.exception.ExceptionCode;
import com.moovda_project.moovda.module.question.entity.Question;
import com.moovda_project.moovda.module.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class AnswerService {
    private final AnswerRepository answerRepository;
    private final QuestionService questionService;

    public Answer createAnswer(Answer answer) {
        Question findQuestion = questionService.findVerifiedQuestion(answer.getQuestion().getQuestionId());

        answer.addQuestion(findQuestion);
        answer.addMember(answer.getMember());

        findQuestion.addAnswerCount(findQuestion.getAnswerCount()); // 답변 수 증가

        return answerRepository.save(answer);
    }

    public Answer updateAnswer(Answer answer, long authenticationMemberId) {

        Answer foundAnswer = findVerifiedAnswer(answer.getAnswerId());

        checkValidatedMember(authenticationMemberId, foundAnswer);

        foundAnswer.setContent(answer.getContent());
        foundAnswer.setTitle(answer.getTitle());
        foundAnswer.setPoster(answer.getPoster());
        foundAnswer.setProdYear(answer.getProdYear());

        return answerRepository.save(foundAnswer);
    }


    public void deleteAnswer(long answerId, long authenticationMemberId) {
        // TODO : 본인 검증 로직 추가
        Answer findAnswerId = findVerifiedAnswer(answerId);
        Question question = findAnswerId.getQuestion();

        checkValidatedMember(authenticationMemberId,findAnswerId);

        question.minusAnswerCount(question.getAnswerCount());
        answerRepository.delete(findAnswerId);
    }

    /** 답변이 등록된 답변인지 확인 메서드 **/
    public Answer findVerifiedAnswer(long answerId){

        Optional<Answer> findAnswer = answerRepository.findById(answerId);

        Answer answer = findAnswer.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.ANSWER_NOT_FOUND));

        return answer;
    }

    /** 작성한 회원인지 확인하는 메서드 **/
    private void checkValidatedMember(long memberId, Answer answer) {
        if(answer.getMember().getMemberId()!= memberId) {
            throw new BusinessLogicException(ExceptionCode.MEMBER_UNAUTHORIZED);
        }
    }

 //   public List<Answer> findAnswers(long questionId) {
//        return answerRepository.findAll(questionId);
 //   }
    // TODO : 페이징 기능 추가
}
