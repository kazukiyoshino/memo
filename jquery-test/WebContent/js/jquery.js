//fadein,fadeout実装
$(function(){
	$(".testclass").text("jquery").css({"color":"red","font-size":"20px"});

//	var i = 1;
//
//	setInterval(function(){
//		$(".image").fadeOut(2000,function(){
//			if(i==2) i--;
//			else i++;
//			$(".image").attr("src","./image/main_image"+i+".png");
//			$(".image").fadeIn(2000);
//		});
//	},4500);
//});



//	var mainCurrentImageNumber = 1; //GenuineCode
//	  var mainChangeImageNumber = 2;
//	  setInterval(function(){
//	    $('.main-image-img').fadeOut(2000,function(){
//	        var srcset = $(".main-image-source").attr("srcset").replace(mainCurrentImageNumber,mainChangeImageNumber);
//	        mainCurrentImageNumber = mainChangeImageNumber;
//	        mainChangeImageNumber++;
//	        if(mainChangeImageNumber > 2)
//	          mainChangeImageNumber = 1;
//	        $(".main-image-source").attr({'srcset':srcset});
//	        $(".main-image-img").attr({'src':srcset});
//	        $(".main-image-img").fadeIn(2000);
//	        });
//	    },10000);


	$(".image").fadeIn(3000,myFadeOut);  //OK
	function myFadeIn(){
		$(".image").fadeIn(3000,myFadeOut);
	}

	function myFadeOut(){
		$(".image").fadeOut(3000,changeImg);
	}

	var i = 1;

	function changeImg(){  //NG
		$(".image").attr("src","./image/main_image"+i+".png");
		if(i==1)
			i++;
		else i--;
		myFadeIn();
	}
	
	
});
