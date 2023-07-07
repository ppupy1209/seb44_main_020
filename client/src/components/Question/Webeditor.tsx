import ReactQuill from 'react-quill';
import 'react-quill/dist/quill.snow.css';

export const WebEditor = () => {
  const toolbarOptions = [
    ['bold', 'italic', 'underline', 'strike'],
    ['blockquote'],
    [{ list: 'ordered' }, { list: 'bullet' }],
    [{ indent: '-1' }, { indent: '+1' }],
    [
      {
        color: [
          '#000000',
          '#e60000',
          '#ff9900',
          '#ffff00',
          '#008a00',
          '#0066cc',
          '#9933ff',
          '#ffffff',
          '#facccc',
          '#ffebcc',
          '#ffffcc',
          '#cce8cc',
          '#cce0f5',
          '#ebd6ff',
          '#bbbbbb',
          '#f06666',
          '#ffc266',
          '#ffff66',
          '#66b966',
          '#66a3e0',
          '#c285ff',
          '#888888',
          '#a10000',
          '#b26b00',
          '#b2b200',
          '#006100',
          '#0047b2',
          '#6b24b2',
          '#444444',
          '#5c0000',
          '#663d00',
          '#666600',
          '#003700',
          '#002966',
          '#3d1466',
          'custom-color',
        ],
      },
      { background: [] },
    ],
    [{ size: ['small', false, 'large', 'huge'] }],
    [{ header: [1, 2, 3, 4, 5, 6, false] }],
  ];
  const module = {
    toolbar: toolbarOptions,
  };

  return (
    <ReactQuill
      style={{ height: '250px' }}
      modules={module}
      theme="snow"
      placeholder="예: 너무 슬프지 않으면서 유쾌한 영화였으면 좋겠어요. 애니메이션이나 해외영화 말고 국내영화로 추천해주세요!"
    />
  );
};
