function additivePersistence(num) {
    num = num.toString()
    let iterationCount = 0;
    while (true) {
        // Check if number is a single digit and return the num iterations if so.
        if (num.length === 1) {
            return iterationCount
        }
        // If not, replace num with the sum of it's digits.
        let sum = 0;
        for (let i in num) {
            sum += parseInt(num[i])
        }
        num = sum.toString();
        iterationCount++;
    }
}

function multiplicativePersistence(num) {
    num = num.toString()
    let iterationCount = 0;
    while (true) {
        // Check if number is a single digit and return the num iterations if so.
        if (num.length === 1) {
            return iterationCount
        }
        // If not, replace num with the product of it's digits.
        let product = 1;
        for (let i in num) {
            product *= parseInt(num[i])
        }
        num = product.toString();
        iterationCount++;
    }
}
console.log("Additive persistence checks:")
console.log("1679583 = " + additivePersistence(1679583))
console.log("123456 = " + additivePersistence(123456))
console.log("6 = " + additivePersistence(6))

console.log("Multiplicative persistence checks:")
console.log("123456 = " + multiplicativePersistence(123456))
console.log("4 = " + multiplicativePersistence(4))