document.addEventListener("DOMContentLoaded",e =>{
	const searchBtn = document.getElementById("search-btn");
	const educationBlogContainer = document.getElementById("education-blog-container");
	searchBtn.addEventListener("click",e =>{
		educationBlogContainer.innerHTML = "";
		const searchText = document.getElementById("search").value;
		const formData = new URLSearchParams();
		formData.append("search",searchText);
		
		fetch("get-educational-blogs",{
			method : 'POST',
			headers :{
				'Content-Type' : 'application/x-www-form-urlencoded'
			},
			body : formData
		}).then(response => response.json())
		.then(data =>{
			data.forEach(item =>{
				const {category,description,htmlId,id,postBy,postCreation,postUpdation,title,userId,userProfileImage} = item;
				const content = '<div class="card"><div class="card-header"><div class="row"><div class="col-sm-2 col-md-2 col-lg-2 "><div class="border border-1"><img class="img-fluid" src="/stuadvisor/resources/assets/useruploads/'+userProfileImage+'" alt="profile"></div></div><div class="col-sm-9 col-md-9 col-lg-9 d-flex align-items-start flex-column"><a data-bs-toggle="collapse" href="#'+htmlId+'" aria-expanded="false" aria-controls="collapseExample">'+title+'</a><p>Category : '+category+'</p><p>Posted by : '+postBy+'</p><p>Posted on : '+postCreation+'</p></div><div class="col-sm-1 col-md-1 col-lg-1 d-flex align-items-center justify-content-center"><a data-bs-toggle="collapse" href="#'+htmlId+'" aria-expanded="false" aria-controls="collapseExample"><i class="ri-add-line fs-2"></i></a></div></div></div><div class="card-body"><div class="collapse" id="'+htmlId+'"><div >'+description+'</div></div></div></div>'
				educationBlogContainer.innerHTML += content;
			})
			
		}).catch(error => console.log(error));
	});
});