<<<<<<< HEAD
"use strict"
var compo_vue = compo_vue || {}
compo_vue = {
/*객체 리터럴 방식 왜 ? 공유하는 값이 없으니까 */
		page_size : ()=>{
			return '<div id="listSizeSelectDiv" class="select_component2 is_selected">'+
			'        <form id="page_form" >'+
			'           <select id="page_size" name="page_size" size="1">'+
			'          </select>'+
			'        </form>'+
			'       </div>'
		}

=======
var compo_vue = compo_vue || {}
compo_vue = {
		pageSize : ()=>{
			return '<div id="listSizeSelectDiv" class="select_component2" style="width: 80px">'+
			'          <ul class="select_list">'+
			'              <li>'+
			'                    <a href="#">5개씩</a>'+
			'              </li>'+
			'          </ul>'+
			'</div>'
		},
		pageSiez2 : ()=>{
			return '<form id="crawl_form" class="form-inline my-2 my-lg-0">  '+
			'  <select name="site" size="1" multiple="">  '+
			'    <option value="naver.com">naver.com</option>'+
			'    <option value="daum.net">daum.net</option>'+
			'    <option value="google.co.kr">google.co.kr</option>'+
			'    <option value="youtube.com">youtube.com</option>'+
			'  </select>'+
			'  </form>'
		}
>>>>>>> 477b340027fb1dbd3ad9ddeb549b90ce575782c4
}