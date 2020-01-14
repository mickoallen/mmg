<template>
    <v-app style="background: #156eac;">
        <v-app-bar color="primary" height="70" app>
            <v-img max-width="300" src="./assets/mmg/title.png"></v-img>
        </v-app-bar>
        <v-content>
            <v-container fluid>
                <router-view></router-view>
            </v-container>
        </v-content>
    </v-app>
</template>

<script>
export default {};
</script>

<style>
</style>
