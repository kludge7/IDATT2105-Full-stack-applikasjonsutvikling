var i = 0;
function buttonClick() {        
    document.getElementById('inc').value = ++i;
}

function toggleImage() {
    var imageIds = ['image1', 'image2', 'image3', 'image4', 'image5', 'image6', 'image7'];

    imageIds.forEach(function(imageId) {
        var image = document.getElementById(imageId);

        if (image.style.display === 'block' || image.style.display === '') {
            image.style.display = 'none';
        } else {
            image.style.display = 'block';
        }
    });
}

function generateSpells() {
    var keywords = generateRandomSpells();

    displaySpells(keywords);
}

function generateRandomSpells() {
    // Array of possible keywords
    var possibleKeywords = ['Aberto', 'Accio', 'Age Line', 'Aguamenti', 'Alarte Ascendare', 'Albus Dumbledores forceful spell', 'Alohomora', 'Anapneo', 'Anteoculatia'];

    // Shuffle the array to get random keywords
    var shuffledKeywords = possibleKeywords.sort(() => Math.random() - 0.5);

    // Return a subset of the shuffled array (adjust as needed)
    return shuffledKeywords.slice(0, 3);
}

function displaySpells(keywords) {
    var keywordList = document.getElementById('keyword-list');

    // Clear existing list items
    keywordList.innerHTML = '';

    // Create and append list items for each keyword
    keywords.forEach(function(keyword) {
        var listItem = document.createElement('li');
        listItem.textContent = keyword;
        keywordList.appendChild(listItem);
    });
}