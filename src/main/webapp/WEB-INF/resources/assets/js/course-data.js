document.addEventListener("DOMContentLoaded", e => {

	const getInnerTextContainer = document.getElementById("getInnerTextContainer"),
 	branchBtn = document.getElementById("branch-btn"),
 	courseSelect = document.getElementById("course"),
 	setSpanContainer = document.getElementById("set-span"),
 	setSemSpan = document.getElementById("set-sem-span"),
 	setSubSpan = document.getElementById("set-sub-span"),
 	branchContainer = document.getElementById("branch-container"),
 	semContainer = document.getElementById("sem-container"),
 	subContainer = document.getElementById("subject-container"),
 	branchInput = document.getElementById("branch-input");

	getInnerTextContainer.addEventListener("click", e => {
		if (e.target.id != "getInnerTextContainer") {
			const option = document.createElement("option");
			option.value = e.target.innerText;
			option.innerHTML = e.target.innerText;
			courseSelect.innerHTML = "";
			courseSelect.append(option);
		}
	})

	branchBtn.addEventListener("click", e => {
		setSpanContainer.innerHTML = "";
				
		const formData = new URLSearchParams();
		formData.append("course", courseSelect.value);
		courseSelect.setAttribute("disabled", true);
		fetch("get-branchs-name", {
			method: "POST",
			headers: {
				"Content-Type": "application/x-www-form-urlencoded"
			},
			body: formData
		}).then(response => response.json())
			.then(data => {
				branchContainer.removeAttribute("hidden");
				if (data.length > 0) {
					data.forEach(branch => {
						const btn = document.createElement("button");
						btn.classList.add("btn", "btn-outline-dark", "rounded-5", "me-2", "mt-2");
						btn.setAttribute("type", "button");
						btn.innerText = branch;
						setSpanContainer.append(btn);
					})
				}
			}).catch(error => console.log(error));
	});

	setSpanContainer.addEventListener("click", e => {
		/*
		const childs = setSpanContainer.children;
		for(let i = 0; i<childs.length;i++){
			childs[i].setAttribute("disabled", true);
		};
		*/
					
		if (e.target.id != "getInnerTextContainer") {
			setSemSpan.innerHTML = "";
			setSubSpan.innerHTML = "";			
			
			const value = e.target.innerText;
			const formData = new URLSearchParams();
			
			branchInput.value = value;
			
			formData.append("branch", value);
			formData.append("course", courseSelect.value);
			
			fetch("get-sem", {
				method: "POST",
				headers: {
					"Content-Type": "application/x-www-form-urlencoded"
				},
				body: formData
			}).then(response => response.json())
				.then(data => {
					semContainer.removeAttribute("hidden");
					if (data.length > 0) {
					data.sort().forEach(sem => {
						const btn = document.createElement("button");
						btn.classList.add("btn", "btn-outline-dark", "rounded-5", "me-2", "mt-2");
						btn.setAttribute("type", "button");
						btn.innerText = sem;
						setSemSpan.append(btn);
					})
				}
				})
				.catch(error => console.log(error));

		};
	});
	setSemSpan.addEventListener("click", e => {
		/*
		const childs = setSemSpan.children;
		for(let i = 0; i<childs.length;i++){
			childs[i].setAttribute("disabled", true);
		};
		*/
		if (e.target.id != "getInnerTextContainer") {
			setSubSpan.innerHTML = "";			
			const value = e.target.innerText;
			const formData = new URLSearchParams();
			formData.append("branch", branchInput.value);
			formData.append("course", courseSelect.value);
			formData.append("sem", value);
			fetch("get-subject", {
				method: "POST",
				headers: {
					"Content-Type": "application/x-www-form-urlencoded"
				},
				body: formData
			}).then(response => response.json())
				.then(data => {
					subContainer.removeAttribute("hidden");
					if (data.length > 0) {
					data.sort().forEach(sub => {
						const a = document.createElement("a");
						a.href = sub[1];
						a.setAttribute("download","download");
						
						const btn = document.createElement("button");
						btn.classList.add("btn", "btn-outline-dark", "rounded-5", "me-2", "mt-2");
						btn.setAttribute("type", "button");
						btn.innerText = sub[0];
						a.append(btn)
						setSubSpan.append(a);
					})
				}
				})
				.catch(error => console.log(error));
		};
	});
});