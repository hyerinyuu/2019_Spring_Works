# 이미지 갤러리 프로젝트
* 2020-01-03

### WYCWYG(What You See What You Get) Editor
* summernote : https://summernote.org/

* textarea에 id값을 설정하고 id에 jquery를 이용해서 속성을 설정해주면
간변하게 WYCWYG 방식으로 문서를 작성할 수 있다.

### Drag and Drop으로 하나의 파일 올리기
1 Drag And Drop을 수행할 box를 만들기
2 jquery에 dragover, drop 이벤트를 설정
3 e.originalEvent.dataTransfer로부터 files 객체를 추출
4 files 객체의 0번째 file 객체를 추출

5 ajax를 사용해서 서버로 파일을 업로드 수행하고
6 파일이름 등을 다시 response로 되돌려 받아서 
7 form의 img_file input box에 저장하고

8 내용을  form post로 upload하면 나머지 정보를 db에 저장 

### Drag And Drop으로 여러개의 파일 올리기
* 1~3 까지는 single file upload와 동일
4. files 객체에 담긴 모든 file 객체를 formData에 append()
5. ajax를 사용해서 server로 upload를 수행하고,
6. Controller는 수신된 파일들을 서버에 저장하고
7. 저장된 파일이름들을 리스트로 생성해서(String[] mFiles)
8. 생성된 파일이름 리스트와 리스트를 표현할 jsp를 rendering하여 다시 return 하고
9. ajax success 코드에서는 return 받은 html 코드를 
10. 리스트를 표현할 box에 보인다.

####이때 리스트를 만들시에
* hidden으로 파일이름리스트를 담을 input box를 만들고
* 각각의 파일이름을 input box의 value에 추가해 둔다.

#### 저장을 하면
* Controller에서는 다시 본문(text)과 함께 hidden input box에 담긴 파일 이름들을 수신해
* String[] mFile 문자열 배열 매개변수로 받아 수신하면 된다.  

### form에서 같은 tag에 다중값을 담아서 controller에 전달하기 img_upload_list.jsp(img_list의 input tag)
#### 1. List<String> 형식으로 전달하기

* form에서 같은 이름의 tag에 다중의 값을 담고
* <input name="title" value="1번">
* <input name="title" value="2번">
* <input name="title" value="3번">

### [1번 방식(ImgGalleryV2 방식)]
* Controller에서 
* String[] title 형식으로 매개변수 설정해서 받을 수 있음
* VO 내부에서 "List<String> title 변수" 를 설정해 두고 VO에 받기


### [2번 방식]

* form에서 같은 이름의 tag에 다중의 값을 담고
* <input name="main[0].title" value="1번">
* <input name="main[1].title" value="2번">
* <input name="main[2].title" value="3번">



