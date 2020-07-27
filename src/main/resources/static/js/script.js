const canvas = document.getElementById("canvas");
const ctx = canvas.getContext("2d");
ctx.strokeStyle = "teal";
ctx.beginPath();
ctx.moveTo(list[0].first * 100, list[0].second * 100)
for (let i = 1; i < list.length; i++) {
        const a = list[i].first;
        const b = list[i].second;
        console.log(a, b);
        ctx.lineTo(a * 100, b * 100);
}
ctx.closePath();
ctx.stroke();
