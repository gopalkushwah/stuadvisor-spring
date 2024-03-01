document.addEventListener("DOMContentLoaded", e => {
	const postAcademicsForm = document.getElementById("post-academics");

	postAcademicsForm.addEventListener("submit", function(e) {
		e.preventDefault();

		const fileData = document.getElementById("study-material-image"),
			title = document.getElementById("title"),
			description = document.getElementById("description"),
			createrId = document.getElementById("creater-id"),
			createrImage = document.getElementById("creater-image"),
			createrName = document.getElementById("creater-name");

		function validateFileType(fileExtension) {
			switch (fileExtension.toLowerCase()) {
				case ".pdf":
				case ".doc":
				case ".docx":
				case ".jpg":
				case ".jpeg":
				case ".png":
				case ".txt":
				case ".csv":
				case ".ppt":
				case ".pptx":
					return true; // Valid file type
				default:
					return false; // Invalid file type
			}
		}

		const fileName = fileData.files[0].name;
		const fileExtension = "." + fileName.split('.').pop();
		
		if (validateFileType(fileExtension)) {
			const data = {
				title: title.value,
				description: description.value,
				createrId: createrId.value,
				createrImage: createrImage.value,
				createrName: createrName.value,
				fileData: fileData.files[0]
			}
			const formData = new FormData();
			for (let key in data) {
				formData.append(key, data[key]);
			};
			fetch('set-study-material', {
				method: 'POST',
				body: formData
			})
				.then(response => response.text())
				.then(data => {
					title.value = "";
					description.value = "";
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
				title: ".pdf , .doc , .docx , .jpg , .jpeg , .png , .txt , .csv , .ppt , .pptx File type are supported only"
			})

		}
	});

});