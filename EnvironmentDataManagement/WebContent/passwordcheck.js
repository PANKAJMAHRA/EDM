function matchpass(){
	var firstpassword=document.f1.userpassword.value;
	var secondpassword=document.f1.userpassword2.value;
	
	if(firstpassword==secondpassword){
		return true;
	}
	else{
		alert("password must be same!");
		return false;
	}
}