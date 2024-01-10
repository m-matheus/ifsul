document.addEventListener('DOMContentLoaded', function () {
    var toggleButtons = document.querySelectorAll('.toggleButton');
    var contentFulls = document.querySelectorAll('.content-full');

    toggleButtons.forEach(function (toggleButton, index) {
        toggleButton.addEventListener('click', function () {
            if (contentFulls[index].style.display === 'none' || contentFulls[index].style.display === '') {
                contentFulls[index].style.display = 'block';
                toggleButton.textContent = 'Ver menos...';
            } else {
                contentFulls[index].style.display = 'none';
                toggleButton.textContent = 'Leia mais...';
            }     
        });
    });
});