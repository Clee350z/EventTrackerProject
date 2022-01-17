console.log("script.js loaded");

window.addEventListener('load', function(e) {

	console.log('document loaded');
	init();
});

function init() {
	console.log('in init()');
	document.festivalForm.lookup.addEventListener('click', function(event) {
		event.preventDefault();
		var festivalName = document.festivalForm.festivalName.value;
		if (festivalName !== '') {
			getFestival(festivalName);

		}
	})


	document.allFestivals.lookup.addEventListener('click', function(event) {
		event.preventDefault();
		getAllFestivals();

	})


	document.newFestivalForm.submit.addEventListener('submit', function(event) {
		event.preventDefault();
		let nff = document.newFestivalForm;
		let newFestival = {
			name: nff.name.value,
			date: nff.date,
			venue: nff.venue.value,
			handicapAccess: nff.handicapAccess.value
		};
		createFestival(newFestival);

	})

	document.updateFestivalForm.update.addEventListener('submit', function(event) {
		event.preventDefault();
		let nff = document.updateFestivalForm;
		let newFestival = {
			id: nff.id.value,
			name: nff.name.value,
			date: nff.date,
			venue: nff.venue.value,
			handicapAccess: nff.handicapAccess.value
		};
		updateFestival(newFestival);

	})



}

function getFestival(festivalName) {
	let xhr = new XMLHttpRequest();
	xhr.open('GET', `api/festivals/${festivalName}`);
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				console.log('Request succeeded');
				let festival = JSON.parse(xhr.responseText);
				displayFestival(festival);
			} else if (xhr.status === 404) {
				displayError("Festival " + festivalName + " not found");
			}
			else {
				displayError('Request failed!');
			}
		}
	}
	xhr.send();
}

function getAllFestivals() {
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/festivals');
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				console.log('Request succeeded');
				let festivals = JSON.parse(xhr.responseText);
				table(festivals);
			} else if (xhr.status === 404) {
				displayError("No festivals found?");
			}
			else {
				displayError('Request failed!');
			}
		}
	}
	xhr.send();
}


function createFestival(e) {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200 || xhr.status === 201) {

				let festival = JSON.parse(xhr.responseText);
				displayFestival(festival);

			}
			else {
				console.error('Festival add failed with status' + xhr.status);
			}
		}
	};
	xhr.setRequestHeader('Content-type', 'application/json')
	xhr.send(JSON.stringify(newFestival));
}





function displayError(msg) {
	var dataDiv = document.getElementById('festivalData');
	dataDiv.textContent = msg;
}

function displayFestival(festival) {

	var dataDiv = document.getElementById('festivalData');
	dataDiv.textContent = '';

	var displayForm = document.createElement('form');
	displayForm.name = 'displayForm';

	let festivalId = document.createElement('input');
	let labelId = displayForm.appendChild(document.createElement('label'));
	labelId.textContent = 'Id : ';
	festivalId.name = 'festivalId';
	festivalId.type = 'number';
	festivalId.value = festival.id;
	displayForm.appendChild(festivalId);
	displayForm.appendChild(document.createElement('br'));

	let festivalName = document.createElement('input');
	let labelName = displayForm.appendChild(document.createElement('label'));
	labelName.textContent = 'Name : ';
	festivalName.name = 'festivalName';
	festivalName.type = 'text';
	festivalName.value = festival.name;
	displayForm.appendChild(festivalName);
	displayForm.appendChild(document.createElement('br'));

	let festivalDate = document.createElement('input');
	let labelDate = displayForm.appendChild(document.createElement('label'));
	labelDate.textContent = 'Date : ';
	festivalDate.name = 'festivalDate';
	festivalDate.type = 'date';
	festivalDate.value = festivalDate;
	displayForm.appendChild(festivalDate);
	displayForm.appendChild(document.createElement('br'));

	let festivalVenue = document.createElement('input');
	let labelVenue = displayForm.appendChild(document.createElement('label'));
	labelVenue.textContent = 'Venue : ';
	festivalVenue.name = 'festivalVenue';
	festivalVenue.type = 'text';
	festivalVenue.value = festival.venue;
	displayForm.appendChild(festivalVenue);
	displayForm.appendChild(document.createElement('br'));

	let h1 = document.createElement('h1');
	h1.textContent = festival.name;
	dataDiv.appendChild(h1);

	//	let ul = document.createElement('ul');
	//	dataDiv.appendChild(ul);
	//	let li = document.createElement('li');
	//	li.textContent = "When : " + festival.date;
	//	ul.appendChild(li);
	//	li = document.createElement('li');
	//	li.textContent = "Where : " + festival.venue;
	//	ul.appendChild(li);
	//	li = document.createElement('li');
	//	li.textContent = "Handicap friendly? : " + festival.handicapAccess;
	//	ul.appendChild(li);

	let formTitle = document.createElement('h3');
	formTitle.textContent = '';
	festivalData.appendChild(displayForm);
	let editButton = document.createElement('button');
	editButton.name = 'editButton';
	editButton.type = 'submit';
	editButton.name = 'Edit Festival';
	editButton.addEventListener('click', function(e) {
		e.preventDefault();


	})


}

function editFestival(festivalId) {
	updatedFestival = {};
	if (displayForm.name.value !== '' && displayForm.venue.value !== '' && displayForm.id.value !== '') {
		updatedFestival.id = displayForm.id.value;
		updatedFestival.name = displayForm.name.value;
		updatedFestival.date = displayForm.date.value;
		updatedFestival.venue = displayForm.venue.value;
		updatedFestival.handicapAccess = displayForm.handicalAccess.value;
	} else {

	}
	sendUpdatedFestival(updatedFestival, festivalId);
}

function sendUpdatedFestival(newFestival, festivalId) {
	let xhr = new XMLHttpRequest();
	xhr.open('PUT', 'api/festivals/' + festivalId);
	xhr.setRequestHeader('Content-type', 'application/json');
	let jsonFestival = JSON.stringify(newFestival);
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200 || xhr.status === 201) {
				let newUpdatedFestival= JSON.parse(xhr.responseText);
				getAllFestivals();
				displayFestival(newUpdatedFestival);
			}
			else {
				console.error(xhr.status);
			}
		}
	}
	xhr.send(jsonFestival);
}


function table(festivals) {
	var table = document.createElement('table');
	document.body.appendChild(table);
	var thead = document.createElement('thead');
	table.appendChild(thead);
	thead.textContent = 'Festival Id / Festival Name';

	var trow = document.createElement('tr');
	table.appendChild(trow);


	var tbody = document.createElement('body');
	table.appendChild(tbody);

	for (let i = 0; i < festivals.length; i++) {
		var tr = document.createElement('tr');
		tbody.appendChild(tr);

		var td1 = document.createElement('td');
		td1.textContent = festivals[i].id;
		tr.appendChild(td1);

		var td2 = document.createElement('td');
		td2.textContent = festivals[i].name;
		tr.appendChild(td2);

		var td3 = document.createElement('td');
		td3.textContent = festivals[i].venue;
		tr.appendChild(td3);

	}


}
