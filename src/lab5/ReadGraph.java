import java.io.*;
import java.util.*;

public class ReadGraph {
	public static GraphInfo readGraph("src/lab5/lab5.txt") {
		GraphInfo g = new GraphInfo();

		try {
			BufferedReader br = new BufferedReader(new FileReader("src/lab5/lab5.txt"));

			g.name = br.readLine();
			g.nNodes = Integer.parseInt(br.readLine());
			g.nEdges = Integer.parseInt(br.readLine());

			g.edges = new EdgeInfo[g.nEdges];

			for (int i=0; i<g.nEdges; i++) {
				String s = br.readLine();
				StringTokenizer st = new StringTokenizer(s);

				g.edges[i] = new EdgeInfo(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			br.close();
		}
		catch (Exception e) {
			return null;
		}

		return g;
	}
}

class GraphInfo {
	public String name;
	public int nNodes;
	public int nEdges;
	public EdgeInfo edges[];

	public GraphInfo() {
		name = null;
		nNodes = 0;
		nEdges = 0;
		edges = null;
	}

	public String toString() {
		String s = "";

		s += "name: " + name + "\n";
		s += "nNodes: " + nNodes + "\n";
		s += "nEdges: " + nEdges + "\n";

		s += "edges: {";

		for (int i=0; i<nEdges-1; i++) {
			s += edges[i] + ",";
		}

		s += edges[nEdges-1] + "}\n";

		return s;
	}
}

class EdgeInfo {
	public int u;
	public int v;

	public EdgeInfo(int u, int v) {
		this.u = u;
		this.v = v;
	}

	public String toString() {
		return "(" + u + "," + v + ")";
	}
}
