function solution(n, words) {
    const wordSet=new Set();
    wordSet.add(words[0]);
    let lastLetter=words[0].slice(-1);
    for(let i=1;i<words.length;i++){
        if (words[i][0]!==lastLetter||wordSet.has(words[i]))
            return [i%n+1,Math.floor(i/n)+1];
        lastLetter=words[i].slice(-1);
        wordSet.add(words[i]);
    }
    return [0,0];
}