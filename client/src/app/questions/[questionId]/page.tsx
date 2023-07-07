interface QuestionDetailPageProps {
  params: { questionId: string };
}

const QuestionDetailPage = ({ params }: QuestionDetailPageProps) => {
  return <div>bye{params.questionId}</div>;
};

export default QuestionDetailPage;

// dynamic route
