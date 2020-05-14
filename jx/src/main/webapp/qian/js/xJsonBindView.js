/***
 * 本js 由 Monster徐 编写
 * 使用方式如下：
 * 
 * <table id="all">
		 		<tr>
		 			<td>标题</td> 
		 			<td>内容</td> 
		 			<td>时间</td> 
		 			<td>操作</td> 
		 		</tr>
		 		 
		 		<tr class="re" >
		 			<td>{{id}} </td> 
		 			<td>{{author}}</td> 
		 			<td>{{name}}</td> 
		 		</tr>
		 		在需要填值得地方写对象中的属性名      使用 {{属性名}}格式
		 		如需加入判断请使用<xif test="{{属性名}}==某值"></xif>标签
		 		会根据判断结果控制是否显示<xif>标签内的内容
		 		判断支持 == != > < >= <=，
 * 
 * 
 * 参数为： 
 *      jsonValue:获取的json数据
 *      xtemp ：绑定的循环元素的父标签    比如table
 *      re   : 需要循环遍历的数据 加上该样式 用于重新加载数据时，删除原有数据
 * 		htmll:存放模板的数组
 * **/
var htmll = new Array();

var xtemps = new Array();


function jsonBindView(jsonValue, xtemp, re) {
	var flagee = false;
	var ddd = -1;
	for(var i = 0; i < xtemps.length; i++) {
		if(xtemps[i] == xtemp) {
			flagee = true;
			ddd = i;
		}
	}

	if(!flagee) {
		ddd++;
		xtemps[ddd] = xtemp;
		var s = $("." + re).prop("outerHTML"); //获取页面模板
		htmll[ddd] = s.toString();
	}

	$("." + re).remove();
    var htmllll = htmll[ddd];
    
    if(jsonValue instanceof Array){
		for(var i = 0; i < jsonValue.length; i++) {
	
			var htmlll = htmllll;
			for(var key in jsonValue[i]) {
				var reg = /\{\{([^\}\}]+)/g;
	
				while(reg.test(htmlll)) {
					var lie = RegExp.$1;
					var ti = "{{" + lie + "}}";
					if(lie == key) {
						htmlll = htmlll.replace(ti, jsonValue[i][key]);
					}
				}
	
			}
			$("#" + xtemp).append(htmlll);
		}
		panduan();
	}else{
		console.error("传入数据不是集合类型，无法遍历循环")
	}

}

function jsonObjectBindView(jsonValue, xtemp, re) {
	var flagee = false;
	var ddd = -1;
	for(var i = 0; i < xtemps.length; i++) {
		if(xtemps[i] == xtemp) {
			flagee = true;
			ddd = i;
		}
	}

	if(!flagee) {
		ddd++;
		xtemps[ddd] = xtemp;
		var s = $("." + re).prop("outerHTML"); //获取页面模板
		htmll[ddd] = s.toString();

	}

	$("." + re).remove();
 
		var htmlll = htmll[ddd];
		
			for(var key in jsonValue) {
				var reg = /\{\{([^\}\}]+)/g;
	
				while(reg.test(htmlll)) {
					var lie = RegExp.$1;
					var ti = "{{" + lie + "}}";
					if(lie == key) {
						htmlll = htmlll.replace(ti, jsonValue[key]);
						//									   
					}
				}
	
			}
			$("#" + xtemp).append(htmlll);
		 
			panduan();
		 
		

}

//处理xif的判断
function panduan() {
	$("xif").each(function() {
		var d1 = $(this).attr("test");

		var regeq = /==/;
		var regdy = />/;
		var regdydy = />=/;
		var regxy = /</;
		var regxydy = /<=/;
		var regbd = /!=/;
		 
		if(regeq.test(d1)) {
			var zhi1 = d1.split("==");
			
			 
			 
			if(zhi1[0] == zhi1[1]) {

			} else {
				$(this).hide();
			}
			
			

		} else if(regbd.test(d1)) {
			var zhi1 = d1.split("!=");
			if(zhi1[0] != zhi1[1]) {

			} else {
				$(this).hide();
			}
		} else if(regdy.test(d1)) {
			if(regdydy.test(d1)) {
				var zhi1 = d1.split(">=");
				if(zhi1[0] >= zhi1[1]) {} else {
					$(this).hide();
				}
			} else {
				var zhi1 = d1.split(">");
				if(zhi1[0] > zhi1[1]) {} else {
					$(this).hide();
				}
			}
		} else if(regxy.test(d1)) {
			if(regxydy.test(d1)) {
				var zhi1 = d1.split("<=");
				if(zhi1[0] <= zhi1[1]) {} else {
					$(this).hide();
				}
			} else {
				var zhi1 = d1.split("<");
				if(zhi1[0] < zhi1[1]) {} else {
					$(this).hide();
				}
			}
		}

	});

}

//表单数据回填 （json数据，表单id）
function formBackValue(jsonValue, formId) {
	for(var name in jsonValue) {
		var obj = $("#" + formId);
		var ival = jsonValue[name];
		var $oinput = obj.find("input[name=" + name + "]");
		if($oinput.attr("type") == "checkbox") {
			if(ival !== null) {
				var checkboxObj = $("[name=" + name + "]");
				var checkArray = ival.split(",");
				for(var i = 0; i < checkboxObj.length; i++) {
					for(var j = 0; j < checkArray.length; j++) {
						if(checkboxObj[i].value == checkArray[j]) {
							checkboxObj[i].click();
						}
					}
				}
			}
		} else if($oinput.attr("type") == "radio") {
			$oinput.each(function() {
				var radioObj = $("[name=" + name + "]");
				for(var i = 0; i < radioObj.length; i++) {
					if(radioObj[i].value == ival) {
						radioObj[i].click();
					}
				}
			});
		} else if($oinput.attr("type") == "textarea") {
			obj.find("[name=" + name + "]").html(ival);
		} else {
			obj.find("[name=" + name + "]").val(ival);
		}

	}
}

//html解析url中的参数，中文也可以解析
//使用方式：   var zhi  = getParam('aaaa');  获取url中aaaa的值
function getParam(sArgName){
	
				 var sHref=decodeURI(location.href);
			      var args    = sHref.split("?");
			      var retval = "";
			      if(args[0] == sHref) /*参数为空*/
			      {
			           return retval; /*无需做任何处理*/
			      }  
			      var str = args[1];
			      args = str.split("&");
			      for(var i = 0; i < args.length; i ++)
			      {
			          str = args[i];
			          var arg = str.split("=");
			          if(arg.length <= 1) continue;
			          if(arg[0] == sArgName) retval = arg[1]; 
			      }
			      return retval;
}

/***                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
 * 分页方法，总页数和
 * @param {Object} page
 * @param {Object} pageall 
 */
function fenye(page, pageall) {
			var color="428bca"; // 颜色控制  D43F3A 红  428bca 蓝  EC971F橙色
			$("#xpage").empty();
			if(page != 1) {
				$("#xpage").append(" <a href='javascript:jumpto(" + (page - 1) + ");'     style='display: inline-block;color: #"+ color+";display: inline-block;height: 25px;line-height: 25px;padding: 0 10px;border: 1px solid #ddd;margin: 0 2px;border-radius: 4px;vertical-align: middle;text-decoration: none;' >上一页</a>");
			} else {
				$("#xpage").append("<span style='display: inline-block;height: 25px;line-height: 25px;padding: 0 10px;margin: 0 2px;color: #bfbfbf;background: #f2f2f2;border: 1px solid #bfbfbf;border-radius: 4px;vertical-align: middle;text-decoration: none;'>上一页</span>");
			}

			if(page != 1) {
				$("#xpage").append("<a href='javascript:jumpto(1);'     style='display: inline-block;color: #"+ color+";display: inline-block;height: 25px;line-height: 25px;padding: 0 10px;border: 1px solid #ddd;margin: 0 2px;border-radius: 4px;vertical-align: middle;text-decoration: none;'>1</a>")
			}
			if(page > 4) {
				$("#xpage").append("<span >...</span>")
				$("#xpage").append("<a href='javascript:jumpto(" + (page - 2) + ");'       style='display: inline-block;color: #"+ color+";display: inline-block;height: 25px;line-height: 25px;padding: 0 10px;border: 1px solid #ddd;margin: 0 2px;border-radius: 4px;vertical-align: middle;text-decoration: none;'>" + (page - 2) + "</a>")
				$("#xpage").append("<a href='javascript:jumpto(" + (page - 1) + ");'      style='display: inline-block;color: #"+ color+";display: inline-block;height: 25px;line-height: 25px;padding: 0 10px;border: 1px solid #ddd;margin: 0 2px;border-radius: 4px;vertical-align: middle;text-decoration: none;'>" + (page - 1) + "</a>")
			} else {
				for(var i = 2; i < page; i++) {
					$("#xpage").append("<a href='javascript:jumpto(" + (i) + ");'     style='display: inline-block;color: #"+ color+";display: inline-block;height: 25px;line-height: 25px;padding: 0 10px;border: 1px solid #ddd;margin: 0 2px;border-radius: 4px;vertical-align: middle;text-decoration: none;' >" + (i) + "</a>")
				}
			}

			$("#xpage").append("<span style='display: inline-block;height: 25px;line-height: 25px;padding: 0 10px;margin: 0 2px;color: #fff;background-color: #"+ color+";border: 1px solid #"+ color+";border-radius: 4px;vertical-align: middle;'>" + page + "</span>")
			if(pageall - page > 3) {
				$("#xpage").append("<a href='javascript:jumpto(" + (page + 1) + ");'    style='display: inline-block;text-decoration: none;color: #"+ color+";display: inline-block;height: 25px;line-height: 25px;padding: 0 10px;border: 1px solid #ddd;margin: 0 2px;border-radius: 4px;vertical-align: middle;text-decoration: none;'  >" + (page + 1) + "</a>")
				$("#xpage").append("<a href='javascript:jumpto(" + (page + 2) + ");'     style='display: inline-block;ctext-decoration: none;olor: #"+ color+";display: inline-block;height: 25px;line-height: 25px;padding: 0 10px;border: 1px solid #ddd;margin: 0 2px;border-radius: 4px;vertical-align: middle;text-decoration: none;' >" + (page + 2) + "</a>")
				 $("#xpage").append("<span >...</span>")
			} else {
				for(var i = page + 1; i < pageall; i++) {
					$("#xpage").append("<a href='javascript:jumpto(" + (i) + ");'      style='display: inline-block;text-decoration: none;color: #"+ color+";display: inline-block;height: 25px;line-height: 25px;padding: 0 10px;border: 1px solid #ddd;margin: 0 2px;border-radius: 4px;vertical-align: middle;'>" + (i) + "</a>")
				}
			}
			if(page != pageall) {
				$("#xpage").append("<a href='javascript:jumpto(" + (pageall) + ");'     style='display: inline-block;text-decoration: none;color: #"+ color+";display: inline-block;height: 25px;line-height: 25px;padding: 0 10px;border: 1px solid #ddd;margin: 0 2px;border-radius: 4px;vertical-align: middle;'>" + (pageall) + "</a>")

			}

			if(page != pageall) {
				$("#xpage").append(" <a href='javascript:jumpto(" + (page + 1) + ");'     style='display: inline-block;text-decoration: none;color: #"+ color+";display: inline-block;height: 25px;line-height: 25px;padding: 0 10px;border: 1px solid #ddd;margin: 0 2px;border-radius: 4px;vertical-align: middle;' >下一页</a>");
			} else {
				$("#xpage").append("<span style='display: inline-block;height: 25px;line-height: 25px;text-decoration: none;padding: 0 10px;margin: 0 2px;color: #bfbfbf;background: #f2f2f2;border: 1px solid #bfbfbf;border-radius: 4px;vertical-align: middle;'>下一页</span>");
			} 
		 
		}
		/***
		 * 外部重写该方法 用于用户点击时操作
		 */
//		function jumpto(page) { 
//			fenye(page, 10)
//		}