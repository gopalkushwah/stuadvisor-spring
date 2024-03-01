document.addEventListener("DOMContentLoaded", e => {
	const dataContainer = document.getElementById('data-container');
	let page = -1;
	const pageSize = 20; // Adjust the page size as needed
	let shouldContinue = true;
	let i = 1;
	const loader = '<div class="card mt-3" aria-hidden="true"><div class="card-body"><h5 class="card-title placeholder-glow"><span class="placeholder col-6"></span></h5><p class="card-text placeholder-glow"><span class="placeholder col-7"></span><span class="placeholder col-4"></span><span class="placeholder col-4"></span><span class="placeholder col-6"></span><span class="placeholder col-8"></span></p><a class="btn btn-primary disabled placeholder col-6" aria-disabled="true"></a></div></div><div class="card" aria-hidden="true"><div class="card-body"><h5 class="card-title placeholder-glow"><span class="placeholder col-6"></span></h5><p class="card-text placeholder-glow"><span class="placeholder col-7"></span><span class="placeholder col-4"></span><span class="placeholder col-4"></span><span class="placeholder col-6"></span><span class="placeholder col-8"></span></p><a class="btn btn-primary disabled placeholder col-6" aria-disabled="true"></a></div></div>';
	dataContainer.innerHTML = loader;

	setTimeout(function() {
		dataContainer.innerHTML = "";

		function loadMoreData() {
			if (!shouldContinue) {
				return; // Stop further requests
			}
			page++;
			fetch("getTopCollege?page=" + page + "&pageSize=" + pageSize, {
				method: 'POST',
				headers: {
					'Content-Type': 'application/json'
				}
			})
				.then(response => response.json())
				.then(data => {
					if (data.length > 0) {
						data.forEach(item => {
							const itemContent = "<div class='col-sm-12 col-md-12 col-lg-12'><div class='row mt-3 border border-2 p-4'><div class='col-sm-2 col-md-2 col-lg-2 border border-1 d-flex align-items-center justify-content-center'><img class='w-50 w-sm-25 w-lg-50' alt='' src=" + item.logo + "/></div><div class='col-sm-7 col-md-6 col-lg-7'><h5>" + item.title + "</h5><p>" + item.location + "</p><p> &#8377;" + (item.fee).substring(1, (item.fee).length) + "</p><p>" + item.course + "</p><p>" + item.rating + "</p></div><div class='col-sm-2 col-md-2 col-lg-2  d-flex flex-column align-items-center justify-content-center'><button class='btn btn-primary'><a href=" + item.url + " class='text-white'>Apply Now</a></button><button class='btn btn-primary mt-2  pe-4 ps-4'><a href=" + item.reviews + " class='text-white'>Reviews</a></button></div></div></div>"
							dataContainer.innerHTML += itemContent;
						});
					} else {
						if (i == 1) {
							const tag = "<div class='card mt-2 border border-2'><div class='card-body d-flex align-items-center justify-content-center'><h1 class='text-danger'>No More Content Available</h1></div></div>";
							dataContainer.innerHTML += tag;
							shouldContinue = false;
							++i;
						}
					}
				})
				.catch(error => console.log('Error loading data:', error));
		}
		function isScrolledToBottom() {
			return Math.floor(window.innerHeight + Math.floor(window.scrollY)) >= document.body.offsetHeight;
		}
		window.addEventListener('scroll', () => {
			if (isScrolledToBottom()) {
				loadMoreData();
			}

		});
		// Initial data load
		loadMoreData();
	}, 2000);
});