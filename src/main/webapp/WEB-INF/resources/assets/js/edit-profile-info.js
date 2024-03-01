document.addEventListener("DOMContentLoaded", e => {

	const
		editNameBtn = document.getElementById("edit-name"),
		editMobileBtn = document.getElementById("edit-mobile"),
		editEmailBtn = document.getElementById("edit-email"),
		editAddressBtn = document.getElementById("edit-address"),
		editGenderBtn = document.getElementById("edit-gender"),
		changePasswordBtn = document.getElementById("change-password"),
		msid = document.getElementById("msid"),
		name = document.getElementById("username"),
		mobile = document.getElementById("usermobile"),
		address = document.getElementById("useraddress"),
		email = document.getElementById("useremail"),
		gender = document.getElementsByName("gender"),
		newpassword = document.getElementById("newpassword"),
		confirmpassword = document.getElementById("confirmpassword");

	editNameBtn.addEventListener("click", e => {
		if (name.value != "") {
			const formData = new URLSearchParams();
			formData.append("name", name.value);
			formData.append("msId", msid.value);
			fetch("edit-user-name", {
				method: 'POST',
				headers: {
					'Content-Type': 'application/x-www-form-urlencoded'
				},
				body: formData
			}).then(response => response.text())
				.then(data => {
					if (data == "Your Name Updated") {
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
					} else {
						const Toast = Swal.mixin({
							toast: true,
							position: 'top',
							showConfirmButton: false,
							iconColor: 'red',
							timer: 3000,
							timerProgressBar: true,
							didOpen: (toast) => {
								toast.addEventListener('mouseenter', Swal.stopTimer)
								toast.addEventListener('mouseleave', Swal.resumeTimer)
							}
						})

						Toast.fire({
							icon: 'warning',
							title: "Something Went Wrong!"
						})
					}

				}).catch(error => console.log(error));
		}

	});

	editAddressBtn.addEventListener("click", e => {
		if (address.value != "") {
			const formData = new URLSearchParams();
			formData.append("address", address.value);
			formData.append("msId", msid.value);
			fetch("edit-user-address", {
				method: 'POST',
				headers: {
					'Content-Type': 'application/x-www-form-urlencoded'
				},
				body: formData
			}).then(response => response.text())
				.then(data => {
					if (data == "Your Address Updated") {
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
					} else {
						const Toast = Swal.mixin({
							toast: true,
							position: 'top',
							showConfirmButton: false,
							iconColor: 'red',
							timer: 3000,
							timerProgressBar: true,
							didOpen: (toast) => {
								toast.addEventListener('mouseenter', Swal.stopTimer)
								toast.addEventListener('mouseleave', Swal.resumeTimer)
							}
						})

						Toast.fire({
							icon: 'warning',
							title: "Something Went Wrong!"
						})
					}

				}).catch(error => console.log(error));
		}

	});

	editGenderBtn.addEventListener("click", e => {
		let getSelectedGender = "";

		for (let i = 0; i < gender.length; i++) {
			if (gender[i].checked) {
				getSelectedGender = gender[i].value;
				break;
			};
		};
		if (getSelectedGender != "") {
			const formData = new URLSearchParams();
			formData.append("gender", getSelectedGender);
			formData.append("msId", msid.value);
			fetch("edit-user-gender", {
				method: 'POST',
				headers: {
					'Content-Type': 'application/x-www-form-urlencoded'
				},
				body: formData
			}).then(response => response.text())
				.then(data => {
					if (data == "Your Gender Updated") {
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
					} else {
						const Toast = Swal.mixin({
							toast: true,
							position: 'top',
							showConfirmButton: false,
							iconColor: 'red',
							timer: 3000,
							timerProgressBar: true,
							didOpen: (toast) => {
								toast.addEventListener('mouseenter', Swal.stopTimer)
								toast.addEventListener('mouseleave', Swal.resumeTimer)
							}
						})

						Toast.fire({
							icon: 'warning',
							title: "Something Went Wrong!"
						})
					}

				}).catch(error => console.log(error));
		}

	});



	editMobileBtn.addEventListener("click", e => {
		if (name.value != "") {
			const formData = new URLSearchParams();
			formData.append("mobile", mobile.value);
			formData.append("msId", msid.value);

			fetch("edit-user-mobile", {
				method: 'POST',
				headers: {
					'Content-Type': 'application/x-www-form-urlencoded'
				},
				body: formData
			}).then(response => response.text())
				.then(data => {
					if (data == "Your Mobile Number is Updated") {
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
					} else {
						const Toast = Swal.mixin({
							toast: true,
							position: 'top',
							showConfirmButton: false,
							iconColor: 'red',
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
		}

	});

	editEmailBtn.addEventListener("click", e => {
		if (name.value != "") {
			const formData = new URLSearchParams();
			formData.append("email", email.value);
			formData.append("msId", msid.value);

			fetch("edit-user-email", {
				method: 'POST',
				headers: {
					'Content-Type': 'application/x-www-form-urlencoded'
				},
				body: formData
			}).then(response => response.text())
				.then(data => {
					if (data == "Your Email is Updated") {
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
					} else {
						const Toast = Swal.mixin({
							toast: true,
							position: 'top',
							showConfirmButton: false,
							iconColor: 'red',
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
		}

	});
	changePasswordBtn.addEventListener("click", e => {

		const passwordRegex = /^(?=.*[A-Z]{1})(?=.*[a-z]{1})(?=.*[!@#$%^&*()_+\-=\[\]{};':\"\\|,.<>\/?]{1})(?=.*\d{1}).{7,25}$/;

		if (newpassword.value == confirmpassword.value) {
			if (passwordRegex.test(newpassword.value)) {
				if (passwordRegex.test(confirmpassword.value)) {
					const formData = new URLSearchParams();
					formData.append("password", newpassword.value);
					formData.append("msId", msid.value);
					fetch("change-user-password", {
						method: 'POST',
						headers: {
							'Content-Type': 'application/x-www-form-urlencoded'
						},
						body: formData
					}).then(response => response.text())
						.then(data => {
							if (data == "Your Password has been Changed") {
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
							} else {
								const Toast = Swal.mixin({
									toast: true,
									position: 'top',
									showConfirmButton: false,
									iconColor: 'red',
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
						iconColor: 'red',
						timer: 3000,
						timerProgressBar: true,
						didOpen: (toast) => {
							toast.addEventListener('mouseenter', Swal.stopTimer)
							toast.addEventListener('mouseleave', Swal.resumeTimer)
						}
					})

					Toast.fire({
						icon: 'warning',
						title: "Confirm Password length should be >=8 and Should contains (2 Uppercase,2 Lowercase , 2 Digit and 2 Spacial Character"
					})
				}
			} else {
				const Toast = Swal.mixin({
					toast: true,
					position: 'top',
					showConfirmButton: false,
					iconColor: 'red',
					timer: 3000,
					timerProgressBar: true,
					didOpen: (toast) => {
						toast.addEventListener('mouseenter', Swal.stopTimer)
						toast.addEventListener('mouseleave', Swal.resumeTimer)
					}
				})

				Toast.fire({
					icon: 'warning',
					title: "Password length should be >=8 and Should contains (2 Uppercase,2 Lowercase , 2 Digit and 2 Spacial Character"
				})
			}

		} else {
			const Toast = Swal.mixin({
				toast: true,
				position: 'top',
				showConfirmButton: false,
				iconColor: 'red',
				timer: 3000,
				timerProgressBar: true,
				didOpen: (toast) => {
					toast.addEventListener('mouseenter', Swal.stopTimer)
					toast.addEventListener('mouseleave', Swal.resumeTimer)
				}
			})

			Toast.fire({
				icon: 'warning',
				title: "Both Passwords should be Same"
			})
		}

	});


	const changeUserProfileImageForm = document.getElementById("change-profile-image");
	changeUserProfileImageForm.addEventListener("submit", function(e) {
		e.preventDefault();

		const fileData = document.getElementById("profile-image"),
			msid1 = document.getElementById("msid1");

		function validateFileType(fileExtension) {
			switch (fileExtension.toLowerCase()) {
				case ".jpg":
				case ".jpeg":
				case ".png":
					return true; // Valid file type
				default:
					return false; // Invalid file type
			}
		}
		console.log(fileData.files);
		const fileName = fileData.files[0].name;
		const fileExtension = "." + fileName.split('.').pop();
		if (validateFileType(fileExtension)) {
			const formData = new FormData();
			formData.append("fileData", fileData.files[0]);
			formData.append("msId", msid1.value);

			fetch('change-user-profile-img', {
				method: 'POST',
				body: formData
			})
				.then(response => response.text())
				.then(data => {
					fileData.value = "";
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
					console.log(error);
				});
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
				title: " .jpg , .jpeg , .png File type are supported only"
			})

		}
	});
});