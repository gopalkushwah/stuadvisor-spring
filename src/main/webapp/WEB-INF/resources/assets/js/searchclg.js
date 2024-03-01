document.addEventListener("DOMContentLoaded", e => {

	/****************** SEARCH COLLEGES BY CITY *********************/
	const cityWiseBtn = document.getElementById("cityWiseBtn");
	const dataContainer = document.getElementById("city-wise-container");
	if (cityWiseBtn != null) {
		cityWiseBtn.addEventListener("click", e => {
			dataContainer.removeAttribute("hidden");
			
			const cityWise = document.getElementById("cityWise").value;
			if(cityWise!=""){
				const loader = '<div class="card mt-3" aria-hidden="true"><div class="card-body"><h5 class="card-title placeholder-glow"><span class="placeholder col-6"></span></h5><p class="card-text placeholder-glow"><span class="placeholder col-7"></span><span class="placeholder col-4"></span><span class="placeholder col-4"></span><span class="placeholder col-6"></span><span class="placeholder col-8"></span></p><a class="btn btn-primary disabled placeholder col-6" aria-disabled="true"></a></div></div><div class="card" aria-hidden="true"><div class="card-body"><h5 class="card-title placeholder-glow"><span class="placeholder col-6"></span></h5><p class="card-text placeholder-glow"><span class="placeholder col-7"></span><span class="placeholder col-4"></span><span class="placeholder col-4"></span><span class="placeholder col-6"></span><span class="placeholder col-8"></span></p><a class="btn btn-primary disabled placeholder col-6" aria-disabled="true"></a></div></div>';
			dataContainer.innerHTML = loader;
			setTimeout(function() {

				const data = {
					cityWise: cityWise
				};
				const formData = new URLSearchParams();
				for (let key in data) {
					formData.append(key, data[key]);
				};
				fetch("search-city-clg", {
					method: 'POST',
					headers: {
						'Content-Type': 'application/x-www-form-urlencoded'
					},
					body: formData
				}).then(response => response.json())
					.then(data => {
						console.log(data);
						dataContainer.innerHTML = "";
						if (data.length > 0) {
							data.forEach(item => {
								const itemContent = "<div class='col-sm-12 col-md-12 col-lg-12'><div class='row mt-3 border border-2 p-4'><div class='col-sm-2 col-md-2 col-lg-2 border border-1 d-flex align-items-center justify-content-center'><img class='w-50 w-sm-25 w-lg-50' alt='' src=" + item.logo + "/></div><div class='col-sm-7 col-md-6 col-lg-7'><h5>" + item.title + "</h5><p>" + item.location + "</p><p> &#8377;" + (item.fee).substring(1, (item.fee).length) + "</p><p>" + item.course + "</p><p>" + item.rating + "</p></div><div class='col-sm-2 col-md-2 col-lg-2  d-flex flex-column align-items-center justify-content-center'><button class='btn btn-primary'><a href=" + item.url + " class='text-white'>Apply Now</a></button><button class='btn btn-primary mt-2  pe-4 ps-4'><a href=" + item.reviews + " class='text-white'>Reviews</a></button></div></div></div>"
								dataContainer.innerHTML += itemContent;
							});
						} else {
							const h1 = "<div class='card mt-2 border border-2'><div class='card-body d-flex align-items-center justify-content-center'><h1 class='text-danger'>No Content Available</h1></div></div>"
							dataContainer.innerHTML += h1;
						}

					}).catch(error => {
						console.log(error);
					});
			}, 2000);
			}else{
				alert("Please enter city name");
			}
				
			
		});
	}
	/****************** SEARCH COLLEGES BY COURSE *********************/
	const courseWiseBtn = document.getElementById("courseWiseBtn");
	const courseDataContainer = document.getElementById("course-wise-container");
	if (courseWiseBtn != null) {
		courseWiseBtn.addEventListener("click", e => {
			courseDataContainer.removeAttribute("hidden");
			const course = document.getElementById("course").value;
			const loader = '<div class="card  mt-3" aria-hidden="true"><div class="card-body"><h5 class="card-title placeholder-glow"><span class="placeholder col-6"></span></h5><p class="card-text placeholder-glow"><span class="placeholder col-7"></span><span class="placeholder col-4"></span><span class="placeholder col-4"></span><span class="placeholder col-6"></span><span class="placeholder col-8"></span></p><a class="btn btn-primary disabled placeholder col-6" aria-disabled="true"></a></div></div><div class="card" aria-hidden="true"><div class="card-body"><h5 class="card-title placeholder-glow"><span class="placeholder col-6"></span></h5><p class="card-text placeholder-glow"><span class="placeholder col-7"></span><span class="placeholder col-4"></span><span class="placeholder col-4"></span><span class="placeholder col-6"></span><span class="placeholder col-8"></span></p><a class="btn btn-primary disabled placeholder col-6" aria-disabled="true"></a></div></div>';
			courseDataContainer.innerHTML = loader;
			setTimeout(function() {

				const data = {
					course: course
				};
				const formData = new URLSearchParams();
				for (let key in data) {
					formData.append(key, data[key]);
				};
				fetch("search-course-clg", {
					method: 'POST',
					headers: {
						'Content-Type': 'application/x-www-form-urlencoded'
					},
					body: formData
				}).then(response => response.json())
					.then(data => {
						courseDataContainer.innerHTML = "";
						if (data.length > 0) {
							data.forEach(item => {
								const itemContent = "<div class='col-sm-12 col-md-12 col-lg-12'><div class='row mt-3 border border-2 p-4'><div class='col-sm-2 col-md-2 col-lg-2 border border-1 d-flex align-items-center justify-content-center'><img class='w-50 w-sm-25 w-lg-50' alt='' src=" + item.logo + "/></div><div class='col-sm-7 col-md-6 col-lg-7'><h5>" + item.title + "</h5><p>" + item.location + "</p><p> &#8377;" + (item.fee).substring(1, (item.fee).length) + "</p><p>" + item.course + "</p><p>" + item.rating + "</p></div><div class='col-sm-2 col-md-2 col-lg-2  d-flex flex-column align-items-center justify-content-center'><button class='btn btn-primary'><a href=" + item.url + " class='text-white'>Apply Now</a></button><button class='btn btn-primary mt-2  pe-4 ps-4'><a href=" + item.reviews + " class='text-white'>Reviews</a></button></div></div></div>"
								courseDataContainer.innerHTML += itemContent;
							});
							console.log(data);
						} else {
							const h1 = "<div class='card mt-2 border border-2'><div class='card-body d-flex align-items-center justify-content-center'><h1 class='text-danger'>No Content Available</h1></div></div>"
							courseDataContainer.innerHTML += h1;
						}

					}).catch(error => {
						console.log(error);
					});
			}, 2000);

		});
	}
	/****************** SEARCH COLLEGES *********************/
	const searchBtn = document.getElementById("search-btn");
	const searchContainer = document.getElementById("search-container");
	if (searchBtn != null) {
		searchBtn.addEventListener("click", e => {
			searchContainer.removeAttribute("hidden");
			
			const loader = '<div class="card  mt-3" aria-hidden="true"><div class="card-body"><h5 class="card-title placeholder-glow"><span class="placeholder col-6"></span></h5><p class="card-text placeholder-glow"><span class="placeholder col-7"></span><span class="placeholder col-4"></span><span class="placeholder col-4"></span><span class="placeholder col-6"></span><span class="placeholder col-8"></span></p><a class="btn btn-primary disabled placeholder col-6" aria-disabled="true"></a></div></div><div class="card" aria-hidden="true"><div class="card-body"><h5 class="card-title placeholder-glow"><span class="placeholder col-6"></span></h5><p class="card-text placeholder-glow"><span class="placeholder col-7"></span><span class="placeholder col-4"></span><span class="placeholder col-4"></span><span class="placeholder col-6"></span><span class="placeholder col-8"></span></p><a class="btn btn-primary disabled placeholder col-6" aria-disabled="true"></a></div></div>';
			searchContainer.innerHTML = loader;
			const course = document.getElementById("search").value;
			setTimeout(function() {
				const data = {
					course: course
				};
				const formData = new URLSearchParams();
				for (let key in data) {
					formData.append(key, data[key]);
				};
				fetch("search", {
					method: 'POST',
					headers: {
						'Content-Type': 'application/x-www-form-urlencoded'
					},
					body: formData
				}).then(response => response.json())
					.then(data => {
						searchContainer.innerHTML = "";
						if (data.length > 0) {
							data.forEach(item => {
								const itemContent = "<div class='col-sm-12 col-md-12 col-lg-12'><div class='row mt-3 border border-2 p-4'><div class='col-sm-2 col-md-2 col-lg-2 border border-1 d-flex align-items-center justify-content-center'><img class='w-50 w-sm-25 w-lg-50' alt='' src=" + item.logo + "/></div><div class='col-sm-7 col-md-6 col-lg-7'><h5>" + item.title + "</h5><p>" + item.location + "</p><p> &#8377;" + (item.fee).substring(1, (item.fee).length) + "</p><p>" + item.course + "</p><p>" + item.rating + "</p></div><div class='col-sm-2 col-md-2 col-lg-2  d-flex flex-column align-items-center justify-content-center'><button class='btn btn-primary'><a href=" + item.url + " class='text-white'>Apply Now</a></button><button class='btn btn-primary mt-2  pe-4 ps-4'><a href=" + item.reviews + " class='text-white'>Reviews</a></button></div></div></div>"
								searchContainer.innerHTML += itemContent;
							});
							console.log(data);
						} else {
							const h1 = "<div class='card mt-2 border border-2'><div class='card-body d-flex align-items-center justify-content-center'><h1 class='text-danger'>No Content Available</h1></div></div>"
							searchContainer.innerHTML += h1;
						}

					}).catch(error => {
						console.log(error);
					});
			}, 2000);
		});
	}
	/****************** SEARCH BY STATE COLLEGES *********************/
	const searchStateBtn = document.getElementById("state-wise-search");
	const searchStateContainer = document.getElementById("state-clg-container");
	if (searchStateBtn != null) {
		searchStateBtn.addEventListener("click", e => {
			searchStateContainer.removeAttribute("hidden");
			
			const loader = '<div class="card  mt-3" aria-hidden="true"><div class="card-body"><h5 class="card-title placeholder-glow"><span class="placeholder col-6"></span></h5><p class="card-text placeholder-glow"><span class="placeholder col-7"></span><span class="placeholder col-4"></span><span class="placeholder col-4"></span><span class="placeholder col-6"></span><span class="placeholder col-8"></span></p><a class="btn btn-primary disabled placeholder col-6" aria-disabled="true"></a></div></div><div class="card" aria-hidden="true"><div class="card-body"><h5 class="card-title placeholder-glow"><span class="placeholder col-6"></span></h5><p class="card-text placeholder-glow"><span class="placeholder col-7"></span><span class="placeholder col-4"></span><span class="placeholder col-4"></span><span class="placeholder col-6"></span><span class="placeholder col-8"></span></p><a class="btn btn-primary disabled placeholder col-6" aria-disabled="true"></a></div></div>';
			searchStateContainer.innerHTML = loader;
			const state = document.getElementById("state").value;
			setTimeout(function() {
				const data = {
					state: state
				};
				const formData = new URLSearchParams();
				for (let key in data) {
					formData.append(key, data[key]);
				};
				fetch("search-state-clg", {
					method: 'POST',
					headers: {
						'Content-Type': 'application/x-www-form-urlencoded'
					},
					body: formData
				}).then(response => response.json())
					.then(data => {
						searchStateContainer.innerHTML = "";
						if (data.length > 0) {
							data.forEach(item => {
								const itemContent = "<div class='col-sm-12 col-md-12 col-lg-12'><div class='row mt-3 border border-2 p-4'><div class='col-sm-2 col-md-2 col-lg-2 border border-1 d-flex align-items-center justify-content-center'><img class='w-50 w-sm-25 w-lg-50' alt='' src=" + item.logo + "/></div><div class='col-sm-7 col-md-6 col-lg-7'><h5>" + item.title + "</h5><p>" + item.location + "</p><p> &#8377;" + (item.fee).substring(1, (item.fee).length) + "</p><p>" + item.course + "</p><p>" + item.rating + "</p></div><div class='col-sm-2 col-md-2 col-lg-2  d-flex flex-column align-items-center justify-content-center'><button class='btn btn-primary'><a href=" + item.url + " class='text-white'>Apply Now</a></button><button class='btn btn-primary mt-2  pe-4 ps-4'><a href=" + item.reviews + " class='text-white'>Reviews</a></button></div></div></div>"
								searchStateContainer.innerHTML += itemContent;
							});
							console.log(data);
						} else {
							const h1 = "<div class='card mt-2 border border-2'><div class='card-body d-flex align-items-center justify-content-center'><h1 class='text-danger'>No Content Available</h1></div></div>"
							searchStateContainer.innerHTML += h1;
						}

					}).catch(error => {
						console.log(error);
					});
			}, 2000);
		});
	}
});