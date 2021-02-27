<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <main>
        <h2 class="main title">공지사항 등록</h2>

        <form method="post" action="/admin/regNotice">
            <div class="margin-top first">
                <h3 class="hidden">공지사항 입력</h3>
                <table class="table">
                    <tbody>
                        <tr>
                            <th>제목</th>
                            <td class="text-align-left text-indent text-strong text-orange" colspan="3">
                                <input type="text" name="title" />
                            </td>
                        </tr>
                        <tr>
                            <th>글쓴이</th>
                            <td class="text-align-left text-indent text-strong text-orange" colspan="3">
                                <input type="text" name="writerID" />
                            </td>
                        </tr>
                        <tr class="content">
                        	<th>내용</th>
                            <td colspan="4"><textarea class="content" name="content" cols="100" rows="20" required></textarea></td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="margin-top text-align-center">
                <input class="btn-text btn-default" type="submit" value="등록" />
                <a class="btn-text btn-cancel" href="/admin/noticeList">취소</a>
            </div>
        </form>

    </main>