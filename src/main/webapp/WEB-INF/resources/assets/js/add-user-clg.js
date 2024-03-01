document.addEventListener("DOMContentLoaded", e => {
	const addClgBtn = document.getElementById("add-clg-btn"),
		name = document.getElementById("clg-name"),
		logo = document.getElementById("logo"),
		clgLocation = document.getElementById("clg-location"),
		clgWebUrl = document.getElementById("clg-web-url"),
		clgCity = document.getElementById("clg-city"),
		clgState = document.getElementById("clg-state"),
		clgReviews = document.getElementById("clg-review"),
		clgRating = document.getElementById("clg-rating"),
		clgFee = document.getElementById("clg-fee"),
		clgCourse = document.getElementById("clg-course"),
		clgByCourse = document.getElementById("clg-by-course"),
		clgUserId = document.getElementById("userId");



	addClgBtn.addEventListener("click", e => {
		const data = {
			title: name.value,
			logo: logo.value,
			location: clgLocation.value,
			url: clgWebUrl.value,
			reviews: clgReviews.value,
			rating: clgRating.value,
			fee: clgFee.value,
			course: clgCourse.value,
			city: clgCity.value,
			bycourse: clgByCourse.value,
			state: clgState.value,
			userId: clgUserId.value
		}

		if (data.title != "") {
			if (data.logo != "") {
				if (data.location != "") {
					if (data.url != "") {
						if (data.reviews != "") {
							if (data.rating != "") {
								if (data.fee != "") {
									if (data.course != "") {
										if (data.city != "") {
											if (data.bycourse != "") {
												if (data.state != "") {


													const formData = new URLSearchParams();
													for (let key in data) {
														formData.append(key, data[key]);
													}

													fetch("insert-college-by-user", {
														method: 'POST',
														headers: {
															'Content-Type': 'application/x-www-form-urlencoded'
														},
														body: formData
													}).then(response => response.text())
														.then(data => {
															if (data == "College Has Been Saved") {
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
																	title: "College Has Been Saved, We will Confirm the truth of information , then it will be published"
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
														icon: 'error',
														title: "Enter State Name"
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
													icon: 'error',
													title: "Enter Course name - First Year "
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
												icon: 'error',
												title: "Enter City Name"
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
											icon: 'error',
											title: "Enter Course Name"
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
										icon: 'error',
										title: "Enter the actual fee of college"
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
									icon: 'error',
									title: "Enter Rating out of 10"
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
								icon: 'error',
								title: "Enter Reviews link of college dunia website"
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
							icon: 'error',
							title: "Please Enter Website Link Of college"
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
						icon: 'error',
						title: "Please Enter The Location of College"
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
					icon: 'error',
					title: "Please Enter College Logo link"
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
				icon: 'error',
				title: "Please Enter College Name"
			})
		}
	});
});