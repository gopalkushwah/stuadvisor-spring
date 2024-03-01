document.addEventListener("DOMContentLoaded", e => {
	const contactUsBtn = document.getElementById("send-message"),
		message = document.getElementById("floatingTextarea"),
		email = document.getElementById("floatingEmail"),
		name = document.getElementById("floatingName");

	contactUsBtn.addEventListener("click", e => {
		if (message.value.length >= 10) {
			if (name.value != "" && email.value != "") {
				const data = {
					name: name.value,
					email: email.value,
					message: message.value
				};
				const formData = new URLSearchParams();
				for (let key in data) {
					formData.append(key, data[key]);
				};
				fetch("contact-us-message", {
					method: 'POST',
					headers: {
						'Content-Type': 'application/x-www-form-urlencoded'
					},
					body: formData
				}).then(response => response.text())
					.then(data => {
						message.value = "";
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
					}).catch(error => {
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
							title: "Something Went Wrong!"
						})
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
					title: "Please Fill All the Information"
				})
			}
		} else {
			const Toast = Swal.mixin({
				toast: true,
				position: 'top',
				showConfirmButton: false,
				timer: 3000,
				iconColor : 'red',
				timerProgressBar: true,
				didOpen: (toast) => {
					toast.addEventListener('mouseenter', Swal.stopTimer)
					toast.addEventListener('mouseleave', Swal.resumeTimer)
				}
			})

			Toast.fire({
				icon: 'warning',
				title: "Message length should be 10 charcter long or above"
			})
		}
	});
});