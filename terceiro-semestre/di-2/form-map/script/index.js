document.addEventListener('DOMContentLoaded', function() {
    const form = document.querySelector('.form');
    const outputDiv = document.querySelector('.output');
    let formDataArray = [];

    form.addEventListener('submit', function(event) {
        event.preventDefault();

        const name = document.getElementById('name').value;
        const email = document.getElementById('email').value;
        const phone = document.getElementById('phone').value;
        const productName = document.getElementById('productName').value;
        const productCategory = document.getElementById('productCategory').value;
        const productModel = document.getElementById('productModel').value;
        const serviceType = document.getElementById('serviceType').value;
        const date = new Date();
        const orderNumber = Math.floor(Math.random() * 1000000);
        
        const formData = { name, email, date, phone, productName, productCategory, productModel, serviceType, orderNumber };
        formDataArray.push(formData);

        formDataArray.sort((a, b) => a.date - b.date);

        outputDiv.innerHTML = `
        <table class="table">
            <thead>
                <tr>
                    <th>Order Number</th>
                    <th>Date</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Product Name</th>
                    <th>Product Category</th>
                    <th>Product Model</th>
                    <th>Service Type</th
                </tr>
            </thead>
            <tbody>
                ${formDataArray.map(data => {
                    return `<tr class="table-item">
                        <td>${data.orderNumber}</td>
                        <td>${data.date.toLocaleDateString()}</td>
                        <td>${data.name}</td>
                        <td>${data.email}</td>
                        <td>${data.phone}</td>
                        <td>${data.productName}</td>
                        <td>${data.productCategory}</td>
                        <td>${data.productModel}</td>
                        <td>${data.serviceType}</td>
                    </tr>`;
                }).join('')}
            </tbody>
        </table>`;
    });
});