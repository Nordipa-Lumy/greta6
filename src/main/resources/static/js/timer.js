function getDate()
	{
		var currentDate = new Date();
		
		var currentHours = currentDate.getHours();
		if (currentHours <10) currentHours = "0" + currentHours;
		
		var currentMinute = currentDate.getMinutes();
		if (currentMinute<10) currentMinute = "0" + currentMinute;
		
		var currentSecond = currentDate.getSeconds();
		if (currentSecond<10) currentSecond = "0" + currentSecond;
		
		document.getElementById("zegar").innerHTML = currentHours+":" + currentMinute + ":" + currentSecond;
		 
		 setTimeout("getDate()",1000);
	}