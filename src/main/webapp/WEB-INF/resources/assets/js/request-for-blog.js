document.addEventListener("DOMContentLoaded", e => {
	const sendRequestBlogBtn = document.getElementById("send-blog-request"),
		title = document.getElementById("title"),
		userId = document.getElementById("creater-id"),
		userImg = document.getElementById("creater-image"),
		userName = document.getElementById("creater-name");

	sendRequestBlogBtn.addEventListener("click", e => {
		if (title.value != "" && userId.value != "" && userImg.value != "" && userName.value != "") {
			const data = {
				title: title.value,
				userId: userId.value,
				userImg: userImg.value,
				userName: userName.value
			}
			const formData = new URLSearchParams();

			for (let key in data) {
				formData.append(key, data[key]);
			}

			fetch("sent-request-for-blog", {
				method: 'POST',
				headers: {
					'Content-Type': 'application/x-www-form-urlencoded'
				},
				body: formData
			}).then(response => response.text())
				.then(data => {
					if (data === "Request Sent Successfuly") {
						title.value = "";
						const Toast = Swal.mixin({
							toast: true,
							position: 'top',
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
					}else{
						const Toast = Swal.mixin({
							toast: true,
							position: 'top',
							showConfirmButton: false,
							timer: 3000,
							timerProgressBar: true,
							didOpen: (toast) => {
								toast.addEventListener('mouseenter', Swal.stopTimer)
								toast.addEventListener('mouseleave', Swal.resumeTimer)
							}
						})

						Toast.fire({
							icon: 'error',
							title: data
						})
					}
				})
		} else {
			const Toast = Swal.mixin({
				toast: true,
				position: 'top',
				showConfirmButton: false,
				timer: 3000,
				timerProgressBar: true,
				didOpen: (toast) => {
					toast.addEventListener('mouseenter', Swal.stopTimer)
					toast.addEventListener('mouseleave', Swal.resumeTimer)
				}
			})

			Toast.fire({
				icon: 'warning',
				title: "Please Fill All Fields!"
			})
		}
	});


});