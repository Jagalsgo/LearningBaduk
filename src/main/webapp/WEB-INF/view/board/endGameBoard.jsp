<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container-md py-5">
		<div class="row">
			<div class="fw-bold h4 mb-4 col-12">바둑 끝내기</div>
			<div class="tableBox">
				<table class="table">
		            <thead class="table-secondary">
		                <tr class="vertical-align">
		                    <th style="width:10%" class="text-center listDate"><i class="fa fa-solid fa-clock fa-lg vertical-align"></i></th>
		                    <th style="width:5%"><i class="fa fa-solid fa-thumbs-up fa-lg vertical-align"></i></th>
		                    <th></th>
		                    <th style="width:15%" class="text-center"><i class="fa fa-solid fa-user fa-lg text-center vertical-align"></i></th>
		                    <th style="width:5%" class="text-center"><i class="fa fa-solid fa-eye fa-lg vertical-align"></i></th>
		                </tr>
		            </thead>
		            <tbody>
		                <tr>
		                    <td class="boardDate text-muted text-center">17-08-14</td>
		                    <td class="boardLike fw-bold">12</td>
		                    <td class="boardTitle ">this is title is title man</td>
		                    <td class="boardWriter fw-bold text-center">
		                    	<div class="position-relative userMenuPointer">writer
		                    	<ul class="userMenuBox">
		                    		<li><a href="dd"><i class="fa fa-solid fa-envelope"></i> 쪽지 보내기</a></li>
		                    		<li><a href="ss"><i class="fa fa-solid fa-flag"></i> 신고하기</a></li>
		                    	</ul>
		                    	</div>
		                    </td>
		                    <td class="boardHit text-muted text-center">12</td>
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
			<div aria-label="Page navigation example" class="col-sm-8 col-md-9" id="pagination">
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
		    <!-- 글 작성 버튼 -->
            <div class="col-sm-3 col-md-2" id="goToWrite">
                <a href="write.jsp" ><button class="btn btn-sm btn-secondary" id="goToWriteBtn" type="button"><i class="fa fa-solid fa-pen"></i> 글작성</button></a>
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