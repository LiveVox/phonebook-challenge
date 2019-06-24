const newContact = {
    name: null,
    lastname: null,
    phone: null
};

const contact = newContact;


function loadContacts(){
    $.ajax({
        url:'http://localhost:8080/PhoneBook/rest/contactManager/findAll',
		type: 'GET',
        success: (response) => {
			$("#contactTable tr").remove();
            renderContacts(response);
        }
    });
}

function addContact(){
    $.ajax({
        url:'http://localhost:8080/PhoneBook/rest/contactManager/addContact',
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(contact),
        success: (response) => {
			loadContacts();
		},
        error: (response) => {
			alert("error: " + response.responseText);
		}
    });
}

function searchContact(keyWords){
    let url = 'http://localhost:8080/PhoneBook/rest/contactManager/findContact?';
    const keyWordsList = keyWords.split(' ');
    url += Object.keys(keyWordsList).map(key => 'keyWords=' + keyWordsList[key]).join('&');
    $.ajax({
        url,
		type: 'GET',
        success: (response) => {
			$("#contactTable tr").remove();
			renderContacts(response);
		},
        error: (response) => {
			alert("error: " + response.responseText);
		}
    });
}

function setContact(field, value) {
	contact[field] = value;
}

function renderContacts(response){
	
	let contactTable = '';
	response.forEach(item => {
		contactTable += '<tr>'
		contactTable += '<td>' + item.name + '</td>';
		contactTable += '<td>' + item.lastname + '</td>';
		contactTable += '<td>' + item.phone + '</td>';
		contactTable += '</tr>';
	});
	$("#contactTable").append(contactTable);
}
