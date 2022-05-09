<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container-md py-5">
		<div class="row">
			<div class="fw-bold h4 mb-4 col-12">회원 관리</div>
			<div class="tableBox">
				<table class="table">
		            <thead class="table-secondary">
		                <tr class="vertical-align">
		                	<th style="width: 2%" class="text-center">#</th>
		                    <th class="text-center listDate"><i class="fa fa-solid fa-clock fa-lg vertical-align"></i></th>
		                    <th>user ID</th>
							<th>user Email</th>
		                    <th class="text-center"><i class="fa fa-solid fa-user fa-lg vertical-align"></i></th>
		                    <th style="width:5%" class="text-center"><i class="fa fa-solid fa-flag vertical-ailgn fa-lg"></i></th>
		                </tr>
		            </thead>
		            <tbody>
		                <tr>
		                	<td class="text-muted">142</td>
		                    <td class="boardDate text-muted text-center">17-08-14</td>
		                    <td class="boardTitle">this is title is title man</td>
		                    <td class="boardTitle">this is title is title man</td>
		                    <td class="boardWriter fw-bold text-center">
		                    	<div class="position-relative userMenuPointer">writer
		                    	<ul class="userMenuBox">
		                    		<li><a href="dd"><i class="fa fa-solid fa-envelope"></i> 쪽지 보내기</a></li>
		                    		<li><a href="s"><i class="fa fa-solid fa-folder-open"></i> 회원 정보 수정</a></li>
		                    		<li><a href="sdfds"><i class="fa fa-solid fa-ban"> 회원 제거</i></a></li>
		                    	</ul>
		                    	</div>
		                    </td>
		                    <td class="boardHit text-muted text-center">0</td>
		                </tr>
		            </tbody>
		        </table>
	        </div>
		</div>
	</div>
	
	<!-- about list  -->
	<div class="container-md my-4">
		<div class="row">
			<!-- go to list  -->
			<div class="col-sm-1 col-md-1" id="goToList"><i class="fa fa-solid fa-list fa-2x"></i></div>
			<!-- pagination -->
			<div aria-label="Page navigation example" class="col-sm-11 col-md-11" id="pagination">
		        <ul class="pagination pagination-sm justify-content-center">
		            <li class="page-item">
		                <a class="page-link" href="#" aria-label="Previous">
		                <span aria-hidden="true">&laquo;</span>
		                </a>
		            </li>
		            <li class="page-item"><a class="page-link" href="#">1</a></li>
		            <li class="page-item"><a class="page-link" href="#">2</a></li>
		            <li class="page-item"><a class="page-link" href="#">3</a></li>
		            <li class="page-item">
		                <a class="page-link" href="#" aria-label="Next">
		                <span aria-hidden="true">&raquo;</span>
		                </a>
		            </li>
		        </ul>
		    </div>
	    </div>
    </div>
    <!-- 검색 폼 -->
    <div class="container-md" id="searchFormBox">
		<form class="search-form">
    		<fieldset>
        		<select class="form-select-sm" name="field" style="width:80px;">
	           		<option value="boardTitle">제목</option>
	           		<option value="userId">작성자</option>
       			</select> 		
       			<input type="text" name="query" value="" style="width: 150px;"/>
				<input class="btn btn-sm btn-secondary" type="submit" value="검색" />
           </fieldset>
       </form>
   </div>