function onUserListClick(){
	let userList = document.getElementById("userList");
	let currentUser = document.getElementById("currentUser");
	let addSerieButton = document.getElementById("addSerieButton");
	if(addSerieButton)
		addSerieButton.classList.toggle("hide");
	userList.classList.toggle("hide");
	
	currentUser.classList.toggle("hide");

}

function seasonClick(id){
	let seasonButton = document.getElementById('seasonButton-'+id);
	let seasonList =  document.getElementsByClassName('seasonList');
	let seasonButList =  document.getElementsByClassName('seasonButton');

	for(let season in seasonList){
		seasonList[season].className = "seasonList hide";
	}
	for(let seasonB in seasonButList){
		seasonButList[seasonB].className = "seasonButton";
	}
	seasonButton.className= "seasonButton selected";

	let selectedId = 'season-'+id;
	let seasonClicked =  document.getElementById(selectedId);
	seasonClicked.classList= ["seasonList"];

}


