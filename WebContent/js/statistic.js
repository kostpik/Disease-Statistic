$(function(){	
		
	var $lastDay = $.ajax({
		     url: 'http://localhost:8080/diseaseStatistic/startDate',		
           metod: 'GET',
		    data: {lastDate: "OK" },
		 success: function(data, textStatus){
			var $dat = data.lastMonth ;
		     }
     
   });
               //хранить последнюю дату на которую есть данные,  берется из БД, при загрузке сраницы
   
  	    			 	
	  var $dateRequest;  
		            $( "#date" ).datepicker({
	        	    regional:'ru',
	        	    dateFormat: 'yy/mm/dd', 
		             range: 'period',
		             dayNames: ["Понедельник", "Вторник", "Среда","Четверг", "Пятница", "Суббота", "Воскресенье"],
		             monthNamesShort: ["Янв.", "Февр.", "Март","Апрель", "Май", "Июнь", "Июль","Авг.","Сент.","Окт.","Нояб.","Дек."],
		             dayNamesMin: ["Пн","Вт","Ср","Чт","Пт","Сб","Вс"],
		             showMonthAfterYear: true,
		             changeMonth: true,
		           //  changeYear: true,
		           //  showOn:'both',		            
		             maxDate: 2013/03/31, // эти значения должны братся из БД после загрузки страницы, но пока так
		        //     minDate: 2013/03/05, //эти значения должны братся из БД после загрузки страницы, но пока так
		             onSelect: function(dateText, inst) { 
		   		     $dateRequest = dateText; //the first parameter of this function var dateAsObject = $(this).datepicker( 'getDate' ); //the getDate method
		   		   }
	            });
	  
	  $("#datepicker").datepicker({
		  
		});
	
		$("#but").click(function() { 
		//	$('#lastTR ~ tr, td').remove();
			$.ajax({
				url: 'http://localhost:8080/diseaseStatistic/orderByDate',		
               metod: 'GET',
			    data: {orderByDate: $dateRequest},
			 success: function(data, textStatus){
					
                             $.each(data, function(index, item){
                            	 var $dat= data[index];
                            	 var $str="<tr>" ;
                            	 $.each($dat, function(key, val){
                            		$str += ( "<td>" + val + "</td>");                           		
                            	 });
                                 $str=$str+"</tr>";
                            	 $("#table_stat").append($str);
     
                             
                        });
			     }
            
          });
	   
	  	    			 
	});
});