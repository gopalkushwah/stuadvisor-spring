document.addEventListener("DOMContentLoaded", e => {

	function isPasswordTrue() {
		function getCookiesAsObject() {
			const cookies = document.cookie; // Get all cookies as a string
			const cookieArray = cookies.split('; '); // Split the string into an array of key-value pairs
			const cookieObject = {};
			cookieArray.forEach((cookie) => {
				const [key, value] = cookie.split('=');
				cookieObject[key] = decodeURIComponent(value); // Decode URI-encoded values
			});
			return cookieObject;
		}
		const cookiesAsObject = getCookiesAsObject();
		let userData;
		for (let key in cookiesAsObject) {
			if (cookiesAsObject.hasOwnProperty(key)) {
				if (key == "ehsk75jh5k5dfs5hjflsa75s4f5sd5f5") {
					userData = JSON.parse(cookiesAsObject[key]);
				}
			}
		}

		Swal.fire({
			title: 'Enter Your Password',
			input: 'text',
			inputAttributes: {
				autocapitalize: 'off'
			},
			confirmButtonText: 'Confirm Password',
			showLoaderOnConfirm: true,
			preConfirm: (password) => {
				const formData = new URLSearchParams();
				formData.append("userId", userData.msId);
				formData.append("password", password);
				return fetch(`confirm-password`, {
					method: 'POST',
					headers: {
						'Content-Type': 'application/x-www-form-urlencoded'
					},
					body: formData

				})
					.then(response => {
						if (!response.ok) {
							throw new Error(response.statusText)
						}
						return response.text()
					}).then(data => {
						if (data == "Password is Correct") {
							Swal.fire(
								`<i class="bx bxs-heart text-danger"></i> ${data}`
							)
						} else {
							Swal.fire({
								icon : "warning",
								title : data,
								timer : 3000
							}).then(result => {
								window.location.href = "profile";
								
							})
							
						}
					})
					.catch(error => {
						Swal.showValidationMessage(
							`Request failed: ${error}`
						)
					})
			},
			allowOutsideClick: false
		});
	}
	isPasswordTrue();
	
//**************************************************************************** */
	

})