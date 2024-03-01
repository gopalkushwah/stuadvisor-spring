document.addEventListener("DOMContentLoaded", e => {
	const address = document.getElementById("useraddress"),
		email = document.getElementById("useremail"),
		gender = document.getElementsByName("gender"),
		mobile = document.getElementById("usermobile"),
		name = document.getElementById("username"),
		password = document.getElementById("userpassword"),
		flexSwitchCheckChecked = document.getElementById("flexSwitchCheckChecked"),
		signUpBtn = document.getElementById("signup-btn"),
		confpassword = document.getElementById("userconfpassword");


	let getSelectedGender = "";
	signUpBtn.addEventListener("click", e => {
		for (let i = 0; i < gender.length; i++) {
			if (gender[i].checked) {
				getSelectedGender = gender[i].value;
				break;
			};
		};
		const emailRegex = /^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/;
		const mobileRegex = /[6-9]\d{9}$/;
		const passwordRegex = /^(?=.*[A-Z]{1})(?=.*[a-z]{1})(?=.*[!@#$%^&*()_+\-=\[\]{};':\"\\|,.<>\/?]{1})(?=.*\d{1}).{7,25}$/;

		if (address.value.length > 0) {
			if (name.value.length > 0) {
				if (emailRegex.test(email.value)) {
					if (mobileRegex.test(mobile.value)) {
						if (passwordRegex.test(password.value)) {
							if (passwordRegex.test(confpassword.value)) {
								if (confpassword.value === password.value) {
									if (getSelectedGender.length > 0) {
										if (flexSwitchCheckChecked.checked) {

											const data = {
												address: address.value,
												name: name.value,
												mobile: mobile.value,
												email: email.value,
												password: password.value,
												gender: getSelectedGender
											};

											const formData = new URLSearchParams();
											for (let key in data) {
												formData.append(key, data[key]);
											};

											fetch("singup-user", {
												method: 'POST',
												headers: {
													'Content-Type': 'application/x-www-form-urlencoded'
												},
												body: formData
											}).then(response => response.text())
												.then(data => {
													if (data === "Signup Success full") {
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
												title: "Please Accept T&C"
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
											title: "Please Select Your Gender"
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
										title: "Both password should be same"
									})

								}
							} else {
								const Toast = Swal.mixin({
									toast: true,
									position: 'top-end',
									iconColor: 'red',
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
									title: "Please Enter Confirm Password"
								})

							}
						} else {
							const Toast = Swal.mixin({
								toast: true,
								position: 'top-end',
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
								title: "Please Enter Valid Password With(2 digit, 2 Uppercase , 2 Lowercase and 2 spacial )"
							})

						}
					} else {
						const Toast = Swal.mixin({
							toast: true,
							position: 'top-end',
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
							title: "Please Enter Valid Mobile Number (Starts with 6,7,8,9) with 10 digit only"
						})

					}
				} else {
					const Toast = Swal.mixin({
						toast: true,
						position: 'top-end',
						showConfirmButton: false,
						timer: 3000,
						iconColor: 'red',
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
					position: 'top-end',
					showConfirmButton: false,
					timer: 3000,
					iconColor: 'red',
					timerProgressBar: true,
					didOpen: (toast) => {
						toast.addEventListener('mouseenter', Swal.stopTimer)
						toast.addEventListener('mouseleave', Swal.resumeTimer)
					}
				})

				Toast.fire({
					icon: 'warning',
					title: "Please Enter Name"
				})

			}
		} else {
			const Toast = Swal.mixin({
				toast: true,
				position: 'top-end',
				showConfirmButton: false,
				timer: 3000,
				iconColor: 'red',
				timerProgressBar: true,
				didOpen: (toast) => {
					toast.addEventListener('mouseenter', Swal.stopTimer)
					toast.addEventListener('mouseleave', Swal.resumeTimer)
				}
			})

			Toast.fire({
				icon: 'warning',
				title: "Please Enter Address"
			})
		}
	})
});