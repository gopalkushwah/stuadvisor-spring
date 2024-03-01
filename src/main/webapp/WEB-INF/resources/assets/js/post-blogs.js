document.addEventListener("DOMContentLoaded", e => {

	const quillEditor = document.getElementsByClassName("ql-editor"),
		title = document.getElementById("title"),
		category = document.getElementById("category"),
		username = document.getElementById("username"),
		userImg = document.getElementById("userImg"),
		userId = document.getElementById("userid"),
		blogsBtn = document.getElementById("blogs-btn");

	blogsBtn.addEventListener("click", e => {
		const data = {
			description: quillEditor[0].innerHTML,
			title: title.value,
			category: category.value,
			postBy: username.value,
			userId: userId.value,
			userProfileImage: userImg.value
		};


		const formData = new URLSearchParams();
		for (let key in data) {
			formData.append(key, data[key]);
		};

		fetch("post-blogs-data", {
			method: "POST",
			headers: {
				"Content-Type": "application/x-www-form-urlencoded"
			},
			body: formData
		}).then(response => response.text())
			.then(data => {
				const Toast = Swal.mixin({
					toast: true,
					position: 'top-end',
					showConfirmButton: false,
					timer: 3000,
					timerProgressBar: true,
					didOpen: (toast) => {
						toast.addEventListener('mouseenter', Swal.stopTimer)
						toast.addEventListener('mouseleave', Swal.resumeTimer)
					}
				})

				Toast.fire({
					icon: 'success',
					title: data
				})
			})
			.catch(error => {
				const Toast = Swal.mixin({
					toast: true,
					position: 'top-end',
					showConfirmButton: false,
					timer: 3000,
					timerProgressBar: true,
					didOpen: (toast) => {
						toast.addEventListener('mouseenter', Swal.stopTimer)
						toast.addEventListener('mouseleave', Swal.resumeTimer)
					}
				})

				Toast.fire({
					icon: 'success',
					title: "Something Went Wrong!"
				})
			});
	})

})