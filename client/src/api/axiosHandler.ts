import axios from "axios";

export const handleDelete = 
    ( url : string) => {
      if (window.confirm('삭제하시겠습니까?')){
        //삭제 확인 경고창
        axios
          .delete(url,
            {headers:
              {'Authorization': ''}}
            )
          .then(() => {
            console.log('삭제 성공');
            alert('삭제가 완료되었습니다.');
            location.reload();
          })
          .catch((error) => {
            console.log('Error:', error.message);
          });
    }}