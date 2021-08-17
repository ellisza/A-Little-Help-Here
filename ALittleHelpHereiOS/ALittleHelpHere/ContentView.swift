//
//  ContentView.swift
//  ALittleHelpHere
//
//  Created by CS User on 8/16/21.
//  Copyright © 2021 CS User. All rights reserved.
//

import SwiftUI

struct ContentView: View {
    @State private var selection = 0
 
    var body: some View {
        TabView(selection: $selection){
            Text("Helps Viewer")
            .font(.title)
            .tabItem {
                VStack {
                    Image("Help")
                    Text("Help")
                }
            }
            .tag(0)
            Text("Map Viewer")
                .font(.title)
                .tabItem {
                    VStack {
                        Image("first")
                        Text("Map")
                    }
                }
                .tag(1)
            Text("Profile")
            .font(.title)
            .tabItem {
                VStack {
                    Image("Help")
                    Text("Profile")
                }
            }
            .tag(2)
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
