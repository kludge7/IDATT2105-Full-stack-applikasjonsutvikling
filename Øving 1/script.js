document.getElementById('incrementButton').addEventListener('click', incrementCounter);
document.getElementById('toggleImageButton').addEventListener('click', toggleMemes);
document.getElementById('generateSpellsButton').addEventListener('click', generateSpells);
let i = 0;

function incrementCounter() {
    document.getElementById('counterValue').value = ++i;
}

function toggleMemes() {
    const memeIds = ['meme1', 'meme2', 'meme3', 'meme4', 'meme5', 'meme6', 'meme7'];

    memeIds.forEach(function (memeId) {
        const meme = document.getElementById(memeId);

        if (meme.style.display === 'block' || meme.style.display === '') {
            meme.style.display = 'none';
        } else {
            meme.style.display = 'block';
        }
    });
}

function generateSpells() {
    const keywords = generateRandomSpells();
    displaySpells(keywords);
}

function generateRandomSpells() {
    const possibleKeywords = [
        'Accio',
        'Aguamenti',
        'Alohomora',
        'Avada Kedavra',
        'Avis',
        'Colloportus',
        'Confringo',
        'Confundo',
        'Crucio',
        'Densaugeo',
        'Deprimo',
        'Depulso',
        'Diffindo',
        'Duro',
        'Engorgio',
        'Episkey',
        'Expecto Patronum',
        'Expelliarmus',
        'Ferula',
        'Fidelius Charm',
        'Finestra',
        'Flagrate',
        'Impedimenta',
        'Imperio',
        'Impervius',
        'Incarcerous',
        'Incendio',
        'Lumos',
        'Muffliato',
        'Nox',
        'Obliviate',
        'Petrificus Totalus',
        'Protego',
        'Reducto',
        'Relashio',
        'Reparo',
        'Rictusempra',
        'Riddikulus',
        'Scourgify',
        'Sectumsempra',
        'Silencio',
        'Stupefy',
        'Tarantallegra',
        'Tergeo',
        'Unbreakable Vow',
        'Wingardium Leviosa'
    ];      
    const shuffledKeywords = possibleKeywords.sort(() => Math.random() - 0.5);

    return shuffledKeywords.slice(0, 3);
}

function displaySpells(keywords) {
    const spellList = document.getElementById('spellList');
    spellList.innerHTML = '';

    keywords.forEach(function (keyword) {
        const listItem = document.createElement('li');
        listItem.textContent = keyword;
        spellList.appendChild(listItem);
    });
}
