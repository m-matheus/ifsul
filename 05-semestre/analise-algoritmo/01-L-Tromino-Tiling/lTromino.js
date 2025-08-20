function createBoard(n, missingX, missingY) {
  const size = 2 ** n;
  const board = Array.from({ length: size }, () => Array(size).fill(''));

  board[missingX][missingY] = 'R';

  function fill(x, y, size, missingRow, missingCol) {
    if (size === 2) {
      for (let dx = 0; dx < 2; dx++) {
        for (let dy = 0; dy < 2; dy++) {
          let i = x + dx;
          let j = y + dy;
          if (!(i === missingRow && j === missingCol)) {
            board[i][j] = 'L';
          }
        }
      }
      return;
    }

    const mid = size / 2;
    const mx = x + mid;
    const my = y + mid;

    const centers = [
      [mx - 1, my - 1], // top-left
      [mx - 1, my],     // top-right
      [mx, my - 1],     // bottom-left
      [mx, my]          // bottom-right
    ];

    let quadrant = 0;
    if (missingRow >= mx) quadrant += 2;
    if (missingCol >= my) quadrant += 1;

    for (let i = 0; i < 4; i++) {
      if (i !== quadrant) {
        const [r, c] = centers[i];
        board[r][c] = 'L';
      }
    }

    const subQuads = [
      [x, y],           // top-left
      [x, y + mid],     // top-right
      [x + mid, y],     // bottom-left
      [x + mid, y + mid]// bottom-right
    ];

    for (let i = 0; i < 4; i++) {
      const [sx, sy] = subQuads[i];
      const [centerRow, centerCol] = centers[i];

      if (i === quadrant) {
        fill(sx, sy, mid, missingRow, missingCol);
      } else {
        fill(sx, sy, mid, centerRow, centerCol);
      }
    }
  }

  fill(0, 0, size, missingX, missingY);
  return board;
}

const n = 3;
const missingX = 1;
const missingY = 0;

const result = createBoard(n, missingX, missingY);
result.forEach(row => console.log(row.join(' ')));
