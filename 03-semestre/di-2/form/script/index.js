document.addEventListener('DOMContentLoaded', function() {
    const validateButton = document.querySelector('.validate');
    const form = document.querySelector('.form');
    const outputDiv = document.createElement('div');

    outputDiv.style.padding = '10px';
    outputDiv.style.marginTop = '16px';
    outputDiv.style.borderRadius = '8px';
    
    form.after(outputDiv);

    validateButton.addEventListener('click', function(e) {
        e.preventDefault();

        let isAllFilled = true;
        let formDataList = document.createElement('ul');
        formDataList.className = 'custom-list';

        form.querySelectorAll('input, select, textarea').forEach(input => {
            if (!input.value) {
                isAllFilled = false;
            } else {
                let listItem = document.createElement('li');
                listItem.className = 'custom-list-item';
                listItem.textContent = `${input.name}: ${input.value}`;
                formDataList.appendChild(listItem);
            }
        });

        if (isAllFilled) {
            outputDiv.innerHTML = '';
            outputDiv.appendChild(formDataList);
            outputDiv.style.border = '1px solid #ccc';
        } else {
            alert('Please fill in all the fields.');
        }
    });
});