document.addEventListener('DOMContentLoaded', function() {
    const calculateButton = document.querySelector('.calculate');

    calculateButton.addEventListener('click', function(e) {
        e.preventDefault();

        const firstNumber = document.querySelector('.first-number').value.trim();
        const secondNumber = document.querySelector('.second-number').value.trim();
        const operator = document.querySelector('.operator').value;
        const resultElement = document.querySelector('.result');

        try {
            const num1 = parseFloat(firstNumber);
            const num2 = parseFloat(secondNumber);

            if (isNaN(num1) || isNaN(num2)) {
                throw new Error('Invalid input: Please enter valid numbers.');
            }

            let result;
            switch (operator) {
                case 'add':
                    result = num1 + num2;
                    break;
                case 'sub':
                    result = num1 - num2;
                    break;
                case 'mul':
                    result = num1 * num2;
                    break;
                case 'div':
                    if (num2 === 0) {
                        throw new Error('Division by zero is not allowed.');
                    }
                    result = num1 / num2;
                    break;
                default:
                    throw new Error('Unsupported operator: Please use add, sub, mul, or div.');
            }

            resultElement.textContent = `Result: ${result}`;
        } catch (error) {
            resultElement.textContent = `Error: ${error.message}`;
        }
    });
});