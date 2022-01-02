class Solution:
    def mostWordsFound(self, sentences: List[str]) -> int:
        return max(len(sentences[i].split()) for i in range(len(sentences)))
