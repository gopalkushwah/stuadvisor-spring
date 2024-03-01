document.addEventListener("DOMContentLoaded", e => {
	const reviewsBtn = document.getElementById("send-reviews"),
		name = document.getElementById("name"),
		userid = document.getElementById("userid"),
		userimg = document.getElementById("userimg"),
		reviewsInput = document.getElementById("reviews-input"),
		stars = document.getElementsByName("stars");
	let starsValue;
	reviewsBtn.addEventListener("click", e => {
		for (let star of stars) {
			if (star.checked) {
				starsValue = star.value;
			}
		}
		if (reviewsInput.value.length >= 10) {
			if (starsValue != undefined && name.value != "" && userid.value != "" && userimg.value != "" && reviewsInput.value != "") {
				const data = {
					name: name.value,
					userid: userid.value,
					userimg: userimg.value,
					stars: starsValue,
					reviewsdata: reviewsInput.value,
				};
				const formData = new URLSearchParams();
				for (let key in data) {
					formData.append(key, data[key]);
				};
				fetch("post-review-data", {
					method: 'POST',
					headers: {
						'Content-Type': 'application/x-www-form-urlencoded'
					},
					body: formData
				}).then(response => response.text())
					.then(data => {
						reviewsInput.value = "";
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
					}).catch(error => {
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
					})
			} else {
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
					title: "Please Fill All the Information"
				})

			}
		} else {
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
				title: "Review length should be 10 charcter long or above"
			})

		}
	});
});