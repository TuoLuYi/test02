// 	  today = new Date().getTime()
//      lastDay = getTimeByDay(1) //��ȡ30��������
//      lastTime = formatTime(lastDay)
//    
//    console.log(lastTime);//2019-03-23

    /* 
    不告诉你
    */
    function getTimeByDay(num) {
        return today + 60 * 60 * 1000 * 24 * num;
    }
    //需要一个  年月日的  2019-01-01 
 
    function getnyr(time) {
       
    	var rr = new Date(time).toISOString().split('T')[0];
    		   
        return rr;
    }
    
    
    // 需要一个 月日周的  01-02 周几
    function getyrz(time) {
        //new Date(time).toISOString()    => 2019-02-23T08:40:35.825Z
    	
    	var rr = new Date(time).toISOString().split('T')[0];
    		ss = rr.split("-");
    		var weekDay = ["周天", "周一", "周二", "周三", "周四", "周五", "周六"];  
    		var myDate = new Date(Date.parse(rr));  
    		   
        return ss[1]+"-"+ss[2]+weekDay[myDate.getDay()];
    }
    
     
    function getQueryString(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
        var reg_rewrite = new RegExp("(^|/)" + name + "/([^/]*)(/|$)", "i");
        var r = window.location.search.substr(1).match(reg);
        var q = window.location.pathname.substr(1).match(reg_rewrite);
        if(r != null){
            return decodeURI(r[2]);
        }else if(q != null){
            return decodeURI(q[2]);
        }else{
            return null;
        }
    }
    
    
    
    