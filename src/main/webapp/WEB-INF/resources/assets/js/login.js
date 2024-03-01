document.addEventListener("DOMContentLoaded", e => {
	const email = document.getElementById("useremail"),
		mobile = document.getElementById("usermobile"),
		password = document.getElementById("userpassword"),
		signInBtn = document.getElementById("signin-btn");

	signInBtn.addEventListener("click", e => {

		if (mobile.value != "") {
			if (email.value != "") {
				const data = {
					mobile: mobile.value,
					email: email.value,
					password: password.value
				};

				const formData = new URLSearchParams();
				for (let key in data) {
					formData.append(key, data[key]);
				};

				fetch("user-login", {
					method: 'POST',
					headers: {
						'Content-Type': 'application/x-www-form-urlencoded'
					},
					body: formData
				}).then(response => response.text())
					.then(data => {
						if (data === "Login Success full") {
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
							}).then(data => {
								window.location.href = "profile"
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
								title: data
							})
						}

					}).catch(error => console.log(error));
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
					title: "Please Enter Valid Email"
				})
			}
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
				title: "Please Enter Mobile Number"
			})
		}
	})
});