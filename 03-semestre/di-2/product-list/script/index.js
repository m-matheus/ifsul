// index.js

document.addEventListener('DOMContentLoaded', () => {
    const productForm = document.querySelector('.form');
    const productList = document.querySelector('.product-list');
    const productNameInput = document.querySelector('#productName');
    const productCategoryInput = document.querySelector('#productCategory');

    // Função para carregar produtos do localStorage
    function loadProducts() {
        const products = JSON.parse(localStorage.getItem('products')) || [];
        return products;
    }

    // Função para salvar produtos no localStorage
    function saveProducts(products) {
        localStorage.setItem('products', JSON.stringify(products));
    }

    // Função para renderizar a lista de produtos
    function renderProducts() {
        const products = loadProducts();
        productList.innerHTML = '';
        products.forEach((product, index) => {
            const li = document.createElement('li');
            li.textContent = `Name: ${product.name}, Category: ${product.category}`;
            const deleteButton = document.createElement('button');
            deleteButton.textContent = 'Delete';
            deleteButton.addEventListener('click', () => {
                deleteProduct(index);
            });
            li.appendChild(deleteButton);
            productList.appendChild(li);
        });
    }

    // Função para adicionar um novo produto
    function addProduct(product) {
        const products = loadProducts();
        products.push(product);
        saveProducts(products);
        renderProducts();
    }

    // Função para deletar um produto
    function deleteProduct(index) {
        const products = loadProducts();
        products.splice(index, 1);
        saveProducts(products);
        renderProducts();
    }

    // Evento de submissão do formulário
    productForm.addEventListener('submit', (event) => {
        event.preventDefault();
        const productName = productNameInput.value.trim();
        const productCategory = productCategoryInput.value.trim();
        if (productName && productCategory) {
            const product = {
                name: productName,
                category: productCategory
            };
            addProduct(product);
            productNameInput.value = '';
            productCategoryInput.value = '';
        }
    });

    // Carregar e renderizar produtos ao carregar a página
    renderProducts();
});