document.addEventListener('DOMContentLoaded', function() {
    const questionMarkImg = document.querySelector('.question-mark');
    const originalSrc = questionMarkImg.src;
    const cards = document.querySelectorAll('.card');
  
    cards.forEach(card => {
      card.addEventListener('mouseenter', function() {
        const emotion = card.id;
        questionMarkImg.src = `assets/${emotion}.jpg`;
      });
      card.addEventListener('mouseleave', function() {
        questionMarkImg.src = originalSrc;
      });
    });
    
  });