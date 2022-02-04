function cercaVideo(){
	var API_KEY = "AIzaSyBJr2X9iE-lWXJOWEn5zkENbYtGk-MNhVg";
	var video = '';
	
	var search = $("#search").val();
	var maxResults = 4;
	
	$.get("https://www.googleapis.com/youtube/v3/search?key="+ API_KEY + "&type=video&part=snippet&maxResults="
		+maxResults+"&q="+search, function(data){
			console.log(data);
			
			data.items.forEach(item =>{
				video = `
					<iframe width="420" height="315" src="http://www.youtube.com/embed/${item.id.videoId}" frameborder="0" allowfullscreen></iframe>
					`
				$("#videos").append(video);
			});
		})
}
