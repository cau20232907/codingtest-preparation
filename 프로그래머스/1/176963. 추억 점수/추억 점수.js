function solution(name, yearning, photo) {
    const yearningByName = new Map();
    for(let i = 0; i < name.length; i++)
        yearningByName.set(name[i],yearning[i]);
    return photo.map((arr)=>
                     arr.map((p)=>yearningByName.get(p) || 0)
                     .reduce((a,b)=>a+b));
}