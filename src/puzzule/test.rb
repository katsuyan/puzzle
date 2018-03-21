def check(last_n, used, list)
  return [1] if used.all? && (list[1].include?(last_n))
  list[last_n].each do |i|
    if used[i - 1] == false
      used[i - 1] = true
      result = check(i, used, list)
      return [i] + result if result.size > 0
      used[i - 1] = false
    end
  end
  []
end

n = 32

square = (2..Math.sqrt(n * 2).floor).map{|i| i ** 2}
list = {}
(1..n).each do |i|
  list[i] = square.map{|s| s - i}.select{|s| s > 0}
end

p square
p list
p check(1, [true] + [false] * (n - 1), list)
