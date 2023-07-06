package com.moovda_project.moovda.question.service;

import com.moovda_project.moovda.exception.BusinessLogicException;
import com.moovda_project.moovda.exception.ExceptionCode;
import com.moovda_project.moovda.question.entity.Question;
import com.moovda_project.moovda.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class QuestionService {
    private final QuestionRepository questionRepository;
//    private final CustomBeanUtils<Question> beanUtils;

    /** 질문 등록 **/
    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    /** 질문 수정 **/
    public Question updateQuestion(Question question) {
        Question findQuestion = findVerifiedQuestion(question.getQuestionId());
        // TODO : 작성한 회원만 수정 가능

        Optional.ofNullable(question.getContent()).ifPresent(content -> findQuestion.setContent(content));
        Optional.ofNullable(question.getTitle()).ifPresent(title -> findQuestion.setTitle(title));


        return questionRepository.save(findQuestion);
    }

    /** 질문 삭제 **/
    public void deleteQuestion(long questionId) {
        // TODO : token으로 로그인 한 회원 확인
        // 로그인 회원의 id를 얻어서 question을 등록한 회원의 id와 비교
        Question findQuestion = findVerifiedQuestion(questionId);

        questionRepository.delete(findQuestion);

    }
    /** 질문이 등록된 질문인지 확인 메서드 **/
    public Question findVerifiedQuestion(long questionId){

        Optional<Question> findQuestion = questionRepository.findById(questionId);

        Question question = findQuestion.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.QUESTION_NOT_FOUND));

        return question;
    }
}
