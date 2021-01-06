class Solution {
public:
    vector<double> calcEquation(vector<vector<string>>& equations,
        vector<double>& values, vector<vector<string>>& queries) {
        unordered_map<string_view, unordered_map<string_view, double>> g;
        unordered_map<string_view, bool> b;
        int n = size(equations);
        for (int i = 0; i != n; ++i) {
            auto&& _1 = equations[i][0];
            auto&& _2 = equations[i][1];
            auto&& value = values[i];
            g[_1][_2] = value;
            g[_2][_1] = 1 / value;
            b[_1] = b[_2] = false;
        }
        vector<double> ret;
        ret.reserve(queries.size());
        for (auto&& qr : queries) {
            ret.emplace_back(
                [&] {
                    string_view src = qr[0];
                    string_view dis = qr[1];
                    if (!b.count(src) || !b.count(dis)) return -1.0;
                    if (auto r = g[src][dis]; r) return r;
                    for (auto&& [_, v] : b) v = false;
                    queue q{ deque{src} };
                    auto&& t = g[src];
                    b[src] = t[src] = 1;
                    while (!q.empty()) {
                        auto tp = q.front();
                        q.pop();
                        for (auto&& [nxt, w] : g[tp]) {
                            if (w && !b[nxt]) {
                                b[nxt] = true;
                                t[nxt] = t[tp] * w;
                                g[nxt][src] = 1 / t[nxt];
                                q.emplace(nxt);
                            }
                        }
                    }
                    return g[src][dis] ? g[src][dis] : -1;
                }());
        }
        return ret;
    }
};