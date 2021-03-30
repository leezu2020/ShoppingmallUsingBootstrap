# ShoppingmallUsingBootstrap
부트스트랩을 사용한 쇼핑몰 홈페이지 제작
*백엔드 개발 공부를 위한 개인적인 프로젝트입니다.*  

프로젝트 기간 : 21.01 ~ 21.03
사용 언어 : Java  
사용 프레임워크 : Spring Framework  

**사용기술**
  #### tiles
 - 반복적으로 사용되는 부분들을 분리
 - 관리가 용이
  #### validator
 - 회원가입시, 조건 충족 여부 확인
 - 오류 메세지 출력
  #### ajax
 - 페이지 갱신없이 이메일 인증
  #### MySQL
 - Database 설계 및 저장
  #### Spring Security
 - 권한 및 인증(로그인/로그아웃)
  #### JavaMailsender
 - 회원가입시, 이메일 인증 구현
  #### 다음 주소 api
 - 주문시, 주소 입력 목적
  ### Async
 - 인증 이메일을 비동기적으로 전송


<br/><br/>
___
**업데이트**
___
 #### 2021.03.10
- 인증 이메일 전송이 전보다 소폭 빨라졌습니다.
- 이메일을 인증해야 가입버튼이 활성화 됩니다.

 #### 2021.03.09
- spring security이 적용되었습니다.
- 회원가입시 이메일 인증이 생겼습니다. (이메일 인증 안해도 넘어가는건 수정 예정입니다.)
- 아이디 기억 기능이 작동되지 않습니다. (추후 수정 예정입니다.)

 #### 2021.03.04
- 상품 페이지에 평균 평점이 별표로 표시됩니다. (아래에는 괄호 사이에 평가 수가 표시됩니다.)
- 관리자 메뉴의 전체 상품 관리에서 상품 조회시 상품 후기 및 평점이 출력됩니다.
- 관리자 메뉴의 전체 상품 관리에서 목록 출력을 수정하였습니다.
- aside의 숫자가 시간이 지나도 사라지지 않습니다.
- 관리자가 상품 삭제시, 해당 상품에 대한 후기도 삭제됩니다.
- 관리자가 상품 삭제시, 해당 상품에 대한 주문도 삭제됩니다. (주문 내역에서 변동사항으로 상품 삭제 안내가 출력됩니다.)
 #### 2021.03.03
- 사용자가 배송상태가 '배송 완료'일 경우, 상품 평가를 진행할 수 있습니다. (상품 평가는 등록후 수정불가합니다.)
- '평가완료'를 클릭할 경우, 해당 상품 페이지로 이동합니다.
- 상품 페이지에서 해당 상품을 구매한 사람들의 후기를 볼 수 있습니다.
- 상품 페이지에 해당 상품의 평균 평점이 보여집니다. (평가 점수는 별로 보여지며, 소숫점은 버림처리되어 출력됩니다.)
- 해당 상품이 판매 기록이 없을시에는, 평점대신 '판매 기록 無'가 표시됩니다.

 #### 2021.03.02
- 관리자가 주문 관리에서 주문 상태를 변경할 수 있습니다.

 #### 2021.02.28
- 주문 목록에서 상품명과 주문상태를 확인할 수 있습니다. (주문상태는 6개로 나누었습니다.)
- 사용자가 로그인하면 왼쪽 메뉴에 나오는 숫자가 바로 표기됩니다.

 #### 2021.02.27
- '장바구니'에서 상품을 선택하여 주문을 할 수 있습니다. (주문시에, 장바구니에서 해당 상품이 삭제됩니다.) (주문 과정에서 주소를 입력할 수 있습니다.)
- '주문내역'에서 주문 내역을 확인할 수 있습니다. (현재 수량 / 금액 / 주문일 및 배송예정일만 출력됩니다.)
- 주문처리시에 장바구니 목록에서 삭제, 상품의 재고 수량이 갱신됩니다.
- 관리자가 모든 주문 목록을 확인할 수 있습니다. (현재 주문자 / 상품아이디 / 수량 / 금액 / 주문일 및 배송예정일만 출력됩니다.)

 #### 2021.02.26 이전 기능
1. 공통
 * 왼쪽 배너에 나온 숫자로 해당 게시글 수를 확인할 수 있습니다. (이벤트 및 관리자의 주문관리는 미구현)
 * '공지사항'에서 공지사항을 검색할 수 있습니다. (by 제목 + 내용 / 제목 / 내용)
 * '전체 상품'란에서 상품을 검색할 수 있습니다. (by 상품명 / 사이즈 / 가격 범위)
 * 우측 상단 '회원 가입'버튼으로 회원 가입을 할 수 있습니다. ( 필수 : ID / Email / Password, 선택 : 이름)
 * 우측 상단 '로그인' 버튼으로 로그인을 할 수 있습니다.
 * 로그인 화면에서 '아이디 기억'을 통해 아이디를 저장할 수 있습니다. (아이디는 7일동안 기억됩니다.)
1. 사용자
 * 상품 자세히 보기에서 수량을 선택하여 장바구니에 담을 수 있습니다. (재고 수량을 초과하여 담을 수는 없습니다.)
 * '전체 상품'란에서 리스트형/배열형 보기로 전환하여 상품을 볼 수 있습니다. (리스트형에서는 사진이 보이지 않습니다.)
 * '내 정보'란에서 이름 및 이메일을 수정할 수 있습니다.
1. 관리자 
 * '회원 관리'에서 회원 목록을 확인할 수 있습니다.
 * '회원 관리'에서 회원을 검색할 수 있습니다. (by 아이디 / 이름 / 아이디 + 이름)
 * '공지사항 관리'에서 공지사항 등록 및 선택 삭제를 할 수 있습니다. (체크 박스 선택후, 페이지 이동시에 체크가 해제됩니다.)
 * '전체 상품 관리'에서 상품 목록을 리스트형으로 확인할 수 있습니다.
 * '전체 상품 관리'에서 상품을 검색할 수 있습니다. (by 상품명 / 사이즈 / 가격 범위)
 * '전체 상품 관리'에서 상품을 선택삭제할 수 있습니다. (상품 삭제시에 사용자의 장바구니에 해당 상품을 삭제 후, <u>상품 삭제 안내 메세지</u>를 남깁니다.)
